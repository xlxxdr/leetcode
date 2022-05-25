package tmp;

import tools.Asserts;
import tools.TreeNode;

public class _965_isUnivalTree extends Asserts {

	public static void main(String[] args) {
		_965_isUnivalTree app = new _965_isUnivalTree();
		isFalse(app.isUnivalTree(TreeNode.deserialize("[9,9,6,9,9]")));
		isFalse(app.isUnivalTree(TreeNode.deserialize("[2,-1,1]")));
		isTrue(app.isUnivalTree(TreeNode.deserialize("[1,1,1,1,1,-1,1]")));
		isFalse(app.isUnivalTree(TreeNode.deserialize("[2,2,2,5,2]")));
		isFalse(app.isUnivalTree(TreeNode.deserialize("[]")));
		isTrue(app.isUnivalTree(TreeNode.deserialize("[2]")));
	}

	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return false;
		} else {
			int baseVal = root.val;
			return testVal(root,baseVal,true);
		}
	}

	private boolean testVal(TreeNode node,int val,boolean testResult){
		if (node.left != null) {
			testResult =  testVal(node.left,val,testResult);
		}
		if (node.right != null) {
			testResult =  testVal(node.right,val,testResult);
		}
		if (!testResult){
			return false;
		}
		int nodeVal = node.val;
		if (nodeVal != val) {
			return false;
		}
		return true;
	}



}
