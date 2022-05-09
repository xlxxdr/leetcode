package code.array;

import code.tools.Asserts;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

示例 1:

输入: nums = [1,3,5,6], target = 5
输出: 2
示例 2:

输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:

输入: nums = [1,3,5,6], target = 7
输出: 4
提示:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为 无重复元素 的 升序 排列数组
-104 <= target <= 104
Related Topics
数组
二分查找
 */
public class _35_SearchInsert {

    public static void main(String[] args) {
        _35_SearchInsert app = new _35_SearchInsert();
        Asserts.equals(0, app.searchInsert(new int[]{1,3,5,6}, 0));
        Asserts.equals(1, app.searchInsert(new int[]{1}, 2));
        Asserts.equals(2, app.searchInsert(new int[]{1, 3, 5, 6}, 5));
        Asserts.equals(1, app.searchInsert(new int[]{1, 3, 5, 6}, 2));
        Asserts.equals(4, app.searchInsert(new int[]{1, 3, 5, 6}, 7));

    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (mid == 0){
                    return 0;
                }
                if (nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (mid == nums.length - 1){
                    return mid + 1;
                }
                if (nums[mid + 1] > target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
