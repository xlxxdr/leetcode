package studyPlan.dataStructure.phase1;

import tools.Asserts;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 839 👎 0

public class _144_preorderTraversal extends Asserts {
 
    public static void main(String[] args) {
        _144_preorderTraversal app = new _144_preorderTraversal();
        equals(getIntList("[1,2,3]"),app.preorderTraversal(TreeNode.deserialize("[1,-1,2,3,-1]")));
        equals(getIntList("[]"),app.preorderTraversal(TreeNode.deserialize("[]")));
        equals(getIntList("[1]"),app.preorderTraversal(TreeNode.deserialize("[1]")));

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
        return result;

    }
}
