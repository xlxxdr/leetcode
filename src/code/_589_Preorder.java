package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import tools.Asserts;
import tools.Node;

public class _589_Preorder {

	public static void main(String[] args) {
		_589_Preorder main = new _589_Preorder();
		Asserts.equals(Arrays.asList(1, 3, 5, 6, 2, 4), main.preorder(Node.buildTreeFromArray(Arrays.asList(1, null, 3, 2, 4, null, 5, 6))));

	}

	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		result.add(root.val);
		if (!root.children.isEmpty()) {
			for (Node child : root.children) {
				preorder(child);
			}
		}
		return result;
	}
}
