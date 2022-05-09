package code.binarysearch;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为 无重复元素 的 升序 排列数组
// -10⁴ <= target <= 10⁴
//
// Related Topics 数组 二分查找 👍 1527 👎 0

public class _35_SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1; // 定义target在左闭右闭的区间里，[left, right]
		while (left <= right) { // 当left==right，区间[left, right]依然有效
			int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
			if (nums[middle] > target) {
				right = middle - 1; // target 在左区间，所以[left, middle - 1]
			} else if (nums[middle] < target) {
				left = middle + 1; // target 在右区间，所以[middle + 1, right]
			} else { // nums[middle] == target
				return middle;
			}
		}
		return right + 1;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
		System.out.println(searchInsert(new int[] {1}, 0));
		System.out.println(searchInsert(new int[] {1,2,3}, 0));
		System.out.println(searchInsert(new int[] {1,2,3}, 4));
	}
}