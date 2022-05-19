package code.tree;


import java.util.*;

import tools.Node;

/*
给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]

输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class _429_LevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            Node node = q.poll();
            if (node.children != null && !node.children.isEmpty()) {
                for (Node child : node.children) {
                    q.add(child);
                    values.add(child.val);
                }
            }
            result.add(values);
        }
        return result;
    }
}
