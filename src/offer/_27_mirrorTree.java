package offer;

import tools.Asserts;
import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
//1 3 6 9
//镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
//9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 258 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _27_mirrorTree extends Asserts {

    public static void main(String[] args) {
        _27_mirrorTree app = new _27_mirrorTree();
        TreeNode treeNode = app.mirrorTree(TreeNode.deserialize("[4,2,7,1,3,6,9]"));
        System.out.println(TreeNode.serialize(treeNode));

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(newRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null){
                queue.add(right);
            }
        }
        return root;
    }
}
