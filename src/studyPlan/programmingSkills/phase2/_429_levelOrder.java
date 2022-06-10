package studyPlan.programmingSkills.phase2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tools.Asserts;
import tools.Node;

//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
//
//
// 示例 2：
//
//
//
//
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
//
//
//
//
// 提示：
//
//
// 树的高度不会超过 1000
// 树的节点总数在 [0, 10^4] 之间
//
// Related Topics 树 广度优先搜索 👍 288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class _429_levelOrder extends Asserts {

	public static void main(String[] args) {
		_429_levelOrder app = new _429_levelOrder();
        app.levelOrder(Node.buildTreeFromArray("[1,-1,2,3,4,5,-1,-1,6,7,-1,8,-1,9,10,-1,-1,11,-1,12,-1,13,-1,-1,14]"));
	}


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rootVal = new ArrayList<>();
        rootVal.add(root.val);
        result.add(rootVal);
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        List<Integer> levelVal = new ArrayList<>();
        List<Node> levelNode = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                levelNode.addAll(children);
                for (Node child : children) {
                    levelVal.add(child.val);
                }
            }
            if (queue.isEmpty() && !levelNode.isEmpty()) {
                queue.addAll(levelNode);
                levelNode.clear();
                List<Integer> vals = new ArrayList<>();;
                for (Integer val : levelVal) {
                    vals.add(val);
                }
                levelVal.clear();
                result.add(vals);
            }
        }
        return result;
    }

}
