package com.genericyzh.algoDS.binarytree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 二叉树的序列化、反序列化
 *
 * @author genericyzh
 * @date 2017/9/23 23:26
 */
public class _27_SerializeAndDeserializeBT {

    /**
     * 使用前序遍历将null也存起来，不存起来的话无法根据这样的前序遍历数组反序列化成功
     * 而且使用前序遍历的另一个原因是，可以马上知道根节点
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void serialHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val).append(",");
            ;
            serialHelper(root.left, sb);
            serialHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        java.util.StringTokenizer st = new java.util.StringTokenizer(data, ",");
        return deserialHelper(st);
    }

    private TreeNode deserialHelper(java.util.StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialHelper(st);
        root.right = deserialHelper(st);
        return root;
    }

    // Encodes a tree to a single string.

    /**
     * 解法二：BFS，把null也保存起来
     */
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>(); // ArrayDeque不能添加null，所以用linkedList
        que.offer(root);
        while (!que.isEmpty()) {
            int length = que.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = que.pollFirst();
                list.add(node == null ? null : node.val);
                if (node != null) {
                    que.offer(node.left);
                    que.offer(node.right);
                }
            }
        }
        return list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.

    /**
     * First we make TreeNode array and set set created TreeNode or null values to T array.
     * then we set left and right children of non-null values of T array.
     */
    public TreeNode deserialize2(String data) {
        if (data.equals("")) return null;
        String[] a = data.split(",");
        TreeNode[] t = new TreeNode[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = getNode(a[i]);
        }
        int j = 1;
        for (int i = 0; i < a.length && j < a.length - 2; i++) {
            if (t[i] != null) {
                t[i].left = t[j++];
                t[i].right = t[j++];
            }
        }

        return t[0];
    }

    TreeNode getNode(String s) {
        if (s.equals("null")) return null;
        return new TreeNode(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree2("[1,2,3,4,null,5,6]");
        _27_SerializeAndDeserializeBT serializeAndDeserializeBT = new _27_SerializeAndDeserializeBT();
//        String serialize = serializeAndDeserializeBT.serialize(treeNode);
//        System.out.println(serialize);
//        System.out.println(serializeAndDeserializeBT.deserialize(serialize));

        String serialize2 = serializeAndDeserializeBT.serialize2(treeNode); // 1,2,3,4,null,5,6,null,null,null,null,null,null
        System.out.println(serialize2);
        System.out.println(serializeAndDeserializeBT.deserialize2(serialize2));
    }

}
