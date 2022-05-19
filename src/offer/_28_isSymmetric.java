package offer;

import tools.Asserts;
import tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _28_isSymmetric extends Asserts {

    public static void main(String[] args) {
        _28_isSymmetric app = new _28_isSymmetric();

    }

    public boolean isSymmetric(TreeNode root) {
        // 利用双端队列 + 层序遍历
        // 对于left节点，先入左值，再入右值
        // 对于right节点，先入右值，再入左值
        Deque deque = new LinkedList();

        return false;
    }
}
