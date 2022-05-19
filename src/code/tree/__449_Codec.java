package code.tree;

import java.util.LinkedList;
import java.util.Queue;

import tools.Asserts;
import tools.TreeNode;

public class __449_Codec {

	public static void main(String[] args) {

		TreeNode leftNode = new TreeNode(2);
		leftNode.left = new TreeNode(4);
		TreeNode rightNode = new TreeNode(3);
		rightNode.right = new TreeNode(5);
		TreeNode treeNode = new TreeNode(1, leftNode, rightNode);
		Codec codec = new Codec();
		Asserts.equals("[1,2,3,4,-1,-1,5,-1,-1,-1,-1]", codec.serialize(treeNode));
		Asserts.equals("[0,-1,-1]", codec.serialize(new TreeNode()));
		Asserts.equals("[]", codec.serialize(null));

		// [1,2,3,4,-1,-1,5,-1,-1,-1,-1]
		// [0,-1,-1]
		// []
		TreeNode node1 = TreeNode.deserialize("[1,2,3,4,-1,-1,5,-1,-1,-1,-1]");
		TreeNode node2 = TreeNode.deserialize("[0,-1,-1]");
		TreeNode node3 = TreeNode.deserialize("[]");

	}

	static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return "[]";
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left != null && node.right == null) {
					queue.offer(node.left);
					queue.offer(new TreeNode(-1));
				} else if (node.left == null && node.right != null) {
					queue.offer(new TreeNode(-1));
					queue.offer(node.right);
				} else if (node.left != null && node.right != null) {
					queue.offer(node.left);
					queue.offer(node.right);
				} else if (node.left == null && node.right == null && node.val != -1) {
					queue.offer(new TreeNode(-1));
					queue.offer(new TreeNode(-1));
				}
				sb.append(node.val);
				if (!queue.isEmpty()) {
					sb.append(",");
				}

			}
			sb.append("]");
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.equals("[]")) {
				return null;
			}

			data = data.substring(1, data.length() - 1);
			String[] values = data.split(",");
			int rootVal = Integer.parseInt(values[0]);
			TreeNode root = new TreeNode(rootVal);
			Queue<TreeNode> queue = new LinkedList();
			queue.offer(root);
			for (int i = 1; i < values.length; i += 2) {
				TreeNode cur = queue.poll();
				int leftVal = Integer.parseInt(values[i]);
				int rightVal = Integer.parseInt(values[i + 1]);
				if (leftVal != -1) {
					TreeNode left = new TreeNode(leftVal);
					cur.left = left;
					queue.offer(left);
				}
				if (rightVal != -1) {
					TreeNode right = new TreeNode(rightVal);
					cur.right = right;
					queue.offer(right);
				}
			}
			return root;

		}
	}
}
