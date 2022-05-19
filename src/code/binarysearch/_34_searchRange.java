package code.binarysearch;

import tools.Asserts;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1670 👎 0
public class _34_searchRange {

	public static void main(String[] args) {
		_34_searchRange app = new _34_searchRange();
		Asserts.equals(new int[] {4, 6}, app.searchRange(new int[] {1, 2, 2, 3, 4, 4, 4}, 4));
		Asserts.equals(new int[] {0, 0}, app.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 5));
		Asserts.equals(new int[] {3, 4}, app.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
		Asserts.equals(new int[] {-1, -1}, app.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
		Asserts.equals(new int[] {-1, -1}, app.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
	}

	public int[] searchRange(int[] nums, int target) {
		boolean leftFound = false;
		boolean rightFound = false;
		int left = 0;
		int right = nums.length - 1;
		int leftPos = -1;
		int rightPos = -1;
		while (left <= right) {
			if (nums[left] == target && leftFound == false) {
				leftPos = left;
				leftFound = true;
			} else {
				left++;
			}
			if (nums[right] == target && rightFound == false) {
				rightPos = right;
				rightFound = true;
			} else {
				right--;
			}
			if (leftFound && rightFound) {
				break;
			}
		}
		if (leftPos != -1 && rightPos == -1) {
			rightPos = leftPos;
		}
		if (rightPos != -1 && leftPos == -1) {
			leftPos = rightPos;
		}
		return new int[] {leftPos, rightPos};
	}

	public int[] searchRange1(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		int leftBound = right;
		left = 0;
		right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return new int[] {leftBound, left};
	}

}
