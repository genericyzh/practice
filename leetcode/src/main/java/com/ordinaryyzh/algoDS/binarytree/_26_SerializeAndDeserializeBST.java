package com.ordinaryyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 * 实现序列化，反序列化二叉搜索树
 * 序列化，先序遍历搜索树得到的字符串特点：root left1 left2 leftX right1 rightX
 * 或者：rootValue (<rootValue) (<rootValue) (<rootValue) |separate line| (>rootValue) (>rootValue)
 * <p>
 * 那么反序列化，子树的根节点都是第一个节点，可以利用队列递归实现
 *
 * @author genericyzh
 * @date 2017/9/22 23:49
 */
public class _26_SerializeAndDeserializeBST {
    private static final String SEP = ",";
    private static final String NULL = "null";

    // 先序遍历（非递归）
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            sb.append(node.val).append(SEP);
            if (node.right != null) {
                stack.offerLast(node.right);
            }
            if (node.left != null) {
                stack.offerLast(node.left);
            }
        }
        return sb.toString();
    }


    // 反序列
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) {
            return null;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            queue.offer(Integer.parseInt(s));
        }
        return getNode(queue);
    }

    // some notes:
    //   5
    //  3 6
    // 2   7
    private TreeNode getNode(Deque<Integer> q) {  //q: 5,3,2,6,7
        if (q.isEmpty()) {
            return null;
        }
        Integer root = q.poll();
        TreeNode node = new TreeNode(root);  //root (5)
        Deque<Integer> leftQue = new ArrayDeque<>();
        while (!q.isEmpty() && q.peek() <= root) {
            leftQue.offer(q.poll());
        }
        // smallerQueue : 3,2   storing elements smaller than 5 (root)
        node.left = getNode(leftQue);
        // q: 6,7   storing elements bigger than 5 (root)
        node.right = getNode(q);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree2("[2,1,3]");
        _26_SerializeAndDeserializeBST serializeAndDeserializeBST = new _26_SerializeAndDeserializeBST();
        String serialize = serializeAndDeserializeBST.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = serializeAndDeserializeBST.deserialize(serialize);
        System.out.println(serializeAndDeserializeBST.serialize(deserialize));
    }
}
