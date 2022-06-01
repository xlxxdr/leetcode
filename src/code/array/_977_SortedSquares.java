package code.array;

import code.tools.Asserts;

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
进阶：

请你设计时间复杂度为 O(n) 的算法解决本问题
Related Topics
数组
双指针
排序
 */
public class _977_SortedSquares {

    public static void main(String[] args) {
        _977_SortedSquares app = new _977_SortedSquares();
        Asserts.equals(new int[]{1,4,9,25},app.sortedSquares(new int[]{-5,-3,-2,-1}));
        Asserts.equals(new int[]{1},app.sortedSquares(new int[]{1}));
        Asserts.equals(new int[]{0,1},app.sortedSquares(new int[]{-1,0}));
        Asserts.equals(new int[]{0,1,9,16,100},app.sortedSquares(new int[]{-4,-1,0,3,10}));
        Asserts.equals(new int[]{4,9,9,49,121},app.sortedSquares(new int[]{-7,-3,2,3,11}));

    }

    public int[] sortedSquares(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int lNum = nums[low] * nums[low] ;
            int hNum = nums[high] * nums[high];
            if (lNum > hNum) {
                nums[low] = nums[high];
                nums[high] = lNum;
                high--;
            } else if (lNum < hNum){
                nums[high] = hNum;
                high--;
            } else {
                high--;
            }
        }
        return nums;
    }

}
