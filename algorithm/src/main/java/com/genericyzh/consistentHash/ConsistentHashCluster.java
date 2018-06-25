package com.genericyzh.consistentHash;

import com.vip.vjtools.vjkit.text.HashUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author genericyzh
 * @date 2018/6/24 21:24
 */
public class ConsistentHashCluster extends Cluster {

    private SortedMap<Long, Node> virNodes = new TreeMap<>(); //存储virNode的hash值和物理node的对应关系

    private static final int VIR_NODE_COUNT = 512; //每一个物理节点对应512个虚拟节点

    private int clusterSize;

    private static final String SPLITOR = "#";

    public ConsistentHashCluster(int clusterSize) {
        super();
        this.clusterSize = clusterSize;
    }

    @Override
    public void addNode(Node node) {
        nodes.add(node);
        IntStream.range(0, VIR_NODE_COUNT)
                .forEach(index -> {
                    long hash = hash(node.getIp(), SPLITOR, DigestUtils.md5Hex(String.valueOf(index)));//计算新增的物理节点对应的512个虚拟节点的hash值
//                    System.out.printf("hash:%s,node:%s%n", hash, node.getIp());
                    virNodes.put(hash, node); //存储virNode的hash值和物理node的对应关系
                });
        clusterSize++;
    }

    @Override
    public void removeNode(Node node) {
        nodes.removeIf(o -> node.getIp().equalsIgnoreCase(o.getIp()));
        IntStream.range(0, VIR_NODE_COUNT)
                .forEach(index -> {
                    long hash = hash(node.getIp() + SPLITOR + index);//计算要删除的物理节点对应的512个虚拟节点的hash值
                    virNodes.remove(hash);//删除virNode的hash值和物理node的对应关系
                });
        clusterSize--;
    }

    //根据key值获取对应的物理node
    @Override
    public Node getNode(String key) {
        long hash = hash(key);
//        System.out.printf("%s%n", hash);

        SortedMap<Long, Node> subMap = hash >= virNodes.lastKey() ? //当前key的hash是否大于等于最大一个hash值
                virNodes.tailMap(Long.MIN_VALUE) : virNodes.tailMap(hash); //返回key大于等于hash的map视图
        if (subMap.isEmpty()) {
            return null;
        }
//        System.out.printf("subMap.firstKey():%s%n", subMap.firstKey());
        return subMap.get(subMap.firstKey());//获取该map视图中最小的key值对应的元素，也就是最接近hash的virNode
    }

    long hash(Object... key) {
        // 使用vip的工具类，murmur hash算法
        return HashUtil.murmur32AsInt(Arrays.toString(key));
    }

    public static void main(String[] args) {

        ConsistentHashCluster cluster = new ConsistentHashCluster(4);
        cluster.addNode(new Node("c1.yywang.info", "192.168.0.1"));
        cluster.addNode(new Node("c2.yywang.info", "192.168.0.2"));
        cluster.addNode(new Node("c3.yywang.info", "192.168.0.3"));
        cluster.addNode(new Node("c4.yywang.info", "192.168.0.4"));

        cluster.virNodes.forEach((aLong, node1) -> System.out.printf("%d--%s%n", aLong, node1));
        System.out.println("--------------");
        int DATA_COUNT = 10000;
        String PRE_KEY = "192.168.0";

        IntStream.range(0, DATA_COUNT).forEach(index -> {
            Node node = cluster.getNode(PRE_KEY + SPLITOR + index); //按照key值找到需要存放的node
            node.put(PRE_KEY + index, "Test Data");//将该key，value值放到该node.data中
        });

        System.out.println("数据分布情况：");
        cluster.nodes.forEach(node -> {
            System.out.println("IP:" + node.getIp() + ",数据量:" + node.getData().size());
        });
        //缓存命中率
        long hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.getNode(PRE_KEY + SPLITOR + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount * 1f / DATA_COUNT);


        cluster.addNode(new Node("c4.yywang.info", "192.168.0.5"));
        //增加一个节点后缓存命中率
        long hitCount2 = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.getNode(PRE_KEY + SPLITOR + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + new BigDecimal(hitCount2 * 1f).divide(new BigDecimal(DATA_COUNT)));


        cluster.removeNode(new Node("c4.yywang.info", "192.168.0.4"));
        //删除一个节点后缓存命中率
        long hitCount3 = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.getNode(PRE_KEY + SPLITOR + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount3 * 1f / DATA_COUNT);

    }
}
