package code.tools;

import java.util.TreeMap;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode of(Integer... elements) {
		TreeNode node = new TreeNode();
		for (Integer element : elements) {

		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode of = TreeNode.of(1, null, 2, 3);
	}

}