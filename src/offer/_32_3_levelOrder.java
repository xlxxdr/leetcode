package offer;

import tools.Asserts;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _32_3_levelOrder extends Asserts {

    public static void main(String[] args) {
        _32_3_levelOrder app = new _32_3_levelOrder();
        System.out.println(app.levelOrder(TreeNode.deserialize("[3,9,20,-1,-1,15,7]")));
        System.out.println(app.levelOrder(TreeNode.deserialize("[1,2,3,4,-1,-1,5]")));
//        equals(nenew ArrayList<>(),app.levelOrder(new TreeNode()));
//        equals(new ArrayList<>(),app.levelOrder(null));

    }

    // 解题思路
    // 从头节点开始，加入下一层的所有节点，当把下一层的节点遍历完成后，这是队列里又为空了
    // 将收集到的节点放到每一层的集合中，同时初始化下一层的集合
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> nodes = new LinkedList();
        List<List<Integer>> result = new ArrayList<>();
        nodes.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);
        List<Integer> nodeList = new ArrayList<>();
        List<TreeNode> levelNodes = new ArrayList<>();
        int i = 0;
        while (!nodes.isEmpty()) {
            TreeNode tmp = nodes.poll();
            if (tmp.left != null) {
                nodeList.add(tmp.left.val);
                levelNodes.add(tmp.left);
            }
            if (tmp.right != null) {
                nodeList.add(tmp.right.val);
                levelNodes.add(tmp.right);
            }
            if (nodes.isEmpty() && levelNodes.size() > 0) {
                nodes.addAll(levelNodes);
                levelNodes = new ArrayList<>();
                if (i % 2 == 0) {
                    Collections.reverse(nodeList);
                    result.add(nodeList);
                } else {
                    result.add(nodeList);
                }
                nodeList = new ArrayList<>();
                i++;
            }
        }
        return result;
    }
}
