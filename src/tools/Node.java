package tools;

import java.util.List;

/**
 * @see  https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png
 */
public class Node {

	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

	//[1,null,3,2,4,null,5,6]
	//            1
	//			/ | \
	//         3  2   4
	//        / \
	//       5   6
	public static Node buildTreeFromArray(String nodeStr) {
		String[] nums = nodeStr.trim().substring(0, nodeStr.length() - 1).split(",");

		return null;
	}
}
