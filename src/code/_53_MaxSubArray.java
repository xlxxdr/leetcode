package code;

import code.tools.Asserts;

/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23
提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class _53_MaxSubArray {

	public static void main(String[] args) {

		Asserts.equals(1, maxSubArray(new int[] {-2, 1}));
		Asserts.equals(-1, maxSubArray(new int[] {-2, -1}));
		Asserts.equals(-1, maxSubArray(new int[] {-1, -2}));
		Asserts.equals(6, maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Asserts.equals(1, maxSubArray(new int[] {1}));
		Asserts.equals(-1, maxSubArray(new int[] {-1}));
		Asserts.equals(23, maxSubArray(new int[] {5, 4, -1, 7, 8}));
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
			if (sum < nums[i]) {
				sum = nums[i];
			}
		}
		return sum;
	}

	/**
	 * Time Limit Exceeded
	 * @param nums
	 * @return
	 */
	public static int maxSubArray1(int[] nums) {
		int max = Integer.MIN_VALUE;
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if (sum > max) {
				max = sum;
			}
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
}
