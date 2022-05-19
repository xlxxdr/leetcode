package offer;

import tools.Asserts;
import tools.TreeNode;

import java.util.LinkedList;

public class _32_1_levelOrder extends Asserts {

    public static void main(String[] args) {
        _32_1_levelOrder app = new _32_1_levelOrder();
        equals(new int[]{3,9,20,15,7},app.levelOrder(TreeNode.deserialize("[3,9,20,-1,-1,15,7]")));
//        equals(new int[]{0},app.levelOrder(new TreeNode()));
//        equals(new int[]{},app.levelOrder(null));

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> nodes = new LinkedList();
        nodes.add(root);
        LinkedList<Integer> result = new LinkedList();
        while (!nodes.isEmpty()){
            TreeNode tmp = nodes.poll();
            result.add(tmp.val);
            if (tmp.left != null){
                nodes.add(tmp.left);
            }
            if (tmp.right != null){
                nodes.add(tmp.right);
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
}
