package _2022_05_30;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import tools.Asserts;
import tools.TreeNode;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1258 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _104_maxDepth extends Asserts {

	public static void main(String[] args) {
		_104_maxDepth app = new _104_maxDepth();
		equals(3,app.maxDepth(TreeNode.deserialize("[1,2,3,4,5]")));
		equals(5,app.maxDepth(TreeNode.deserialize("[1,2,-1,3,-1,4,-1,5,-1]")));
		equals(3,app.maxDepth(TreeNode.deserialize("[3,9,20,-1,-1,15,7]")));
		equals(1,app.maxDepth(TreeNode.deserialize("[3]")));
	}


	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxDepth = 1;
		// 利用层序遍历的方式
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		List<TreeNode> levelNodes = new LinkedList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (Objects.nonNull(node.left)) {
				levelNodes.add(node.left);
			}
			if (Objects.nonNull(node.right)) {
				levelNodes.add(node.right);
			}
			// 如果当前层遍历完成且下一层还有节点，将下一层的数据加入，重复这个步骤
			if (queue.isEmpty() && !levelNodes.isEmpty()){
				queue.addAll(levelNodes);
				maxDepth++;
				levelNodes.clear();
			}
		}
		return maxDepth;
	}

	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxDepth = 1;
		// 利用层序遍历的方式
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		List<TreeNode> levelNodes = new LinkedList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (Objects.nonNull(node.left)) {
				levelNodes.add(node.left);
			}
			if (Objects.nonNull(node.right)) {
				levelNodes.add(node.right);
			}
			// 如果当前层遍历完成且下一层还有节点，将下一层的数据加入，重复这个步骤
			if (queue.isEmpty() && !levelNodes.isEmpty()){
				queue.addAll(levelNodes);
				maxDepth++;
				levelNodes.clear();
			}
		}
		return maxDepth;
	}
}
