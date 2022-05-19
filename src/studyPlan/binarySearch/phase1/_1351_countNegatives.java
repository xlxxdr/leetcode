package studyPlan.binarySearch.phase1;

import tools.Asserts;

//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
//
//
//
// 示例 1：
//
//
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
//
//
// 示例 2：
//
//
//输入：grid = [[3,2],[1,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
// Related Topics 数组 二分查找 矩阵 👍 96 👎 0
public class _1351_countNegatives {

    public static void main(String[] args) {
        _1351_countNegatives app = new _1351_countNegatives();
        Asserts.equals(3, app.countNegatives(new int[][]{
                {3, -1}, {-1, -1}
        }));
        Asserts.equals(6, app.countNegatives(new int[][]{
                {3, 2}, {-3, -3}, {-3, -3}, {-3, -3}
        }));

        Asserts.equals(1, app.countNegatives(new int[][]{
                {7, -3}
        }));
        Asserts.equals(0, app.countNegatives(new int[][]{
                {3, 2}, {1, 0}
        }));
        Asserts.equals(8, app.countNegatives(new int[][]{
                {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}
        }));


    }

    public int countNegatives(int[][] grid) {
        int sum = 0;
        int negPos = grid[0].length - 1;
        int count = 0;
        for (int[] nums : grid) {
            if (negPos == -1){
                sum = sum + count;
                continue;
            }
            for (int i = negPos; i >= 0; i--) {
                if (nums[i] >= 0) {
                    negPos = i;
                    break;
                } else {
                    // 每一行负数的个数想加
                    count++;
                    negPos = i;
                    if (negPos == 0){
                        // 如果遇到第0个位置都是负数，那么接下来的每一行都是负数，
                        // 所以设置标记为-1，当进入这行时，判断一下
                        negPos = -1;
                    }
                }
            }
            sum = sum + count;
        }
        return sum;
    }

}
