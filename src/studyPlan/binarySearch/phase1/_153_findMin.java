package studyPlan.binarySearch.phase1;
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
//
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
// 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
//
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
//
//
// 示例 3：
//
//
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数 互不相同
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
// Related Topics 数组 二分查找 👍 755 👎 0

import tools.Asserts;


public class _153_findMin extends Asserts {

    public static void main(String[] args) {
        _153_findMin app = new _153_findMin();
        equals(1, app.findMin(getIntArray(1)));
        equals(1, app.findMin(getIntArray(2, 1)));
        equals(1, app.findMin(getIntArray(3, 4, 5, 1, 2)));
        equals(0, app.findMin(getIntArray(4, 5, 6, 7, 0, 1, 2)));
        equals(11, app.findMin(getIntArray(11, 13, 15, 17)));
    }

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int firstPos = 0;
        int secondPos = 1;
        int lenCount = 0;
        // 当second指向最后一个元素时，结束循环
        while (secondPos != nums.length) {
            // 如果旋转到原来的顺序，则直接返回第一个元素
            if (nums[secondPos] >= nums[firstPos]) {
                secondPos++;
                lenCount++;
            } else if (nums[secondPos] < nums[firstPos]) {
                // 说明左边小于右边，结束
                return nums[secondPos];
            }
            if (lenCount == nums.length - 1) {
                return nums[0];
            }
        }
        return 0;
    }
}
