package _2022_05_30;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import tools.Asserts;
import tools.TreeNode;

//给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
//输入: root = [1]
//输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 460 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
public class _404_sumOfLeftLeaves extends Asserts {

	public static void main(String[] args) {
		_404_sumOfLeftLeaves app = new _404_sumOfLeftLeaves();
		equals(24, app.sumOfLeftLeaves(TreeNode.deserialize("[3,9,20,-1,-1,15,7]")));
		equals(0, app.sumOfLeftLeaves(TreeNode.deserialize("[1]")));
		equals(4, app.sumOfLeftLeaves(TreeNode.deserialize("[1,2,3,4,5]")));
		equals(5,app.sumOfLeftLeaves(TreeNode.deserialize("[1,2,-1,3,-1,4,-1,5,-1]")));
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		// 利用层序遍历的方式
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (Objects.nonNull(node.left)) {
				queue.offer(node.left);
				if (Objects.isNull(node.left.left) && Objects.isNull(node.left.right)) {
					sum += node.left.val;
				}
			}
			if (Objects.nonNull(node.right)) {
				queue.offer(node.right);
			}

		}
		return sum;
	}

}
