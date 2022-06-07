package studyPlan.algorithms.phase1;

import tools.Asserts;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序 👍 544 👎 0
public class _977_sortedSquares extends Asserts {

    public static void main(String[] args) {
        _977_sortedSquares app = new _977_sortedSquares();
        equals(getIntArray("[1,4,9,25]"),app.sortedSquares(getIntArray("[-5,-3,-2,-1]")));
        equals(getIntArray("[0,1,9,16,100]"),app.sortedSquares(getIntArray("[-4,-1,0,3,10]")));
        equals(getIntArray("[4,9,9,49,121]"),app.sortedSquares(getIntArray("[-7,-3,2,3,11]")));
        equals(getIntArray("[49]"),app.sortedSquares(getIntArray("[-7]")));

    }

    public int[] sortedSquares(int[] nums) {
        // 定义两个指针，一个左指针（从数组头），一个右指针（从数组尾）同时往中间遍历
        // 这样每次取出的值都是最大的，因为负数小的平方值反而大
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;
        while (left <= right) {
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if (leftVal < rightVal) {
                result[pos--] = rightVal;
                right--;
            } else if (leftVal > rightVal) {
                result[pos--] = leftVal;
                left++;
            } else {
                result[pos--] = rightVal;
                right--;
            }
        }
        return result;
    }
}
