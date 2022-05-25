package offer;

import tools.Asserts;
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
//
//
// 示例 2：
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
//
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
//
// Related Topics 数组 双指针 二分查找 👍 188 👎 0

public class _57_twoSum extends Asserts {

	public static void main(String[] args) {
		_57_twoSum app = new _57_twoSum();
		equals(getIntArray("[16,60]"), app.twoSum(getIntArray("[14,15,16,22,53,60]"), 76));
		equals(getIntArray("[30,32]"), app.twoSum(getIntArray("[16,16,18,24,30,32]"), 62));
		equals(getIntArray("[16,32]"), app.twoSum(getIntArray("[16,16,18,24,30,32]"), 48));
		equals(getIntArray("[2,7]"), app.twoSum(getIntArray("[2,7]"), 9));
		equals(getIntArray("[2,7]"), app.twoSum(getIntArray("[2,7,11,15]"), 9));
		equals(getIntArray("[10,30]"), app.twoSum(getIntArray("[10,26,30,31,47,60]"), 40));
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums.length < 2) {
			return new int[] {};
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] >= target) {
				right = mid - 1;
			}
		}
		if (left == 0) {
			return new int[] {-1, -1};
		}
		int pos1 = 0;
		int pos2 = 1;
		while (pos2 != left) {
			int n = target - nums[pos1];
			if (nums[pos2] == n) {
				return new int[] {nums[pos1], nums[pos2]};
			} else if (nums[pos2] < n) {
				if (pos2 == left - 1) {
					pos1++;
					pos2 = pos1 + 1;
				} else {
					pos2++;
				}
			} else if (nums[pos2] > n) {
				pos1++;
				pos2 = pos1++;

			}
		}
		return new int[2];
	}

}
