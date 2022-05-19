package code.array;

import static tools.Asserts.*;

import java.util.Arrays;

import tools.Asserts;

//给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
//
// 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：2
//解释：
//只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [1,10,2,9]
//输出：16
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 数组 数学 排序 👍 221 👎 0
public class _462_minMoves2 {

	public static void main(String[] args) {
		_462_minMoves2 app = new _462_minMoves2();
		Asserts.equals(2, app.minMoves2(getIntArray(1, 2, 3)));
		Asserts.equals(16, app.minMoves2(getIntArray(1,10,2,9)));
	}

	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int mid = nums.length / 2;
		int base = nums[mid];
		int moveSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < mid) {
				moveSum += base - nums[i];
			} else {
				moveSum += nums[i] - base;
			}
		}
		return moveSum;
	}
}
