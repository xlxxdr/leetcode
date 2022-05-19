package studyPlan.binarySearch.phase1;

import tools.Asserts;

//给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
//
// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <=
//j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。
//
// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
//
// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
//
//
//
//
// 示例 1：
//
//
//输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//输出：2
//解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
//
//
// 示例 2：
//
//
//输入：nums1 = [2,2,2], nums2 = [10,10,1]
//输出：1
//解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//最大距离是 1 ，对应下标对 (0,1) 。
//
// 示例 3：
//
//
//输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//输出：2
//解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= 10⁵
// 1 <= nums2.length <= 10⁵
// 1 <= nums1[i], nums2[j] <= 10⁵
// nums1 和 nums2 都是 非递增 数组
//
// Related Topics 贪心 数组 双指针 二分查找 👍 34 👎 0
public class _1855_maxDistance {

    public static void main(String[] args) {
        _1855_maxDistance app = new _1855_maxDistance();
        Asserts.equals(2, app.maxDistance(Asserts.getIntArray(55, 30, 5, 4, 2),
                Asserts.getIntArray(100, 20, 10, 10, 5)));
        Asserts.equals(1, app.maxDistance(Asserts.getIntArray(2, 2, 2),
                Asserts.getIntArray(10, 10, 1)));
        Asserts.equals(2, app.maxDistance(Asserts.getIntArray(30, 29, 19, 5),
                Asserts.getIntArray(25, 25, 25, 25, 25)));
    }


    /**
     * 解题思路：
     * 步骤一 取出nums1中的每一个数，然后在nums2中找到第一个比他小的位置，此时可以计算到nums[i]的距离
     * 步骤二 此时break,终止循环，记录nums2的当前位置K，然后再从nums1中取出一个元素，从nums2中k的位置重复步骤一
     * 步骤三 如果nums2遍历到了末尾，为终止整个计算
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        // 两个数组非递增，递减的
        int maxDis = 0;
        int nums2Pos = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2Pos == nums2.length - 1) {
                break;
            }
            int distance = 0;
            for (int k = nums2Pos; k < nums2.length; k++) {
                if (nums1[i] > nums2[k]) {
                    nums2Pos = k;
                    break;
                }
                if (nums1[i] <= nums2[k]){
                    distance = k;
                }
            }
            if ((distance - i) > maxDis) {
                maxDis = distance - i;
            }
        }
        return maxDis;
    }


    public int maxDistance_timeout(int[] nums1, int[] nums2) {
        // 两个数组非递增，递减的
        int maxDis = 0;
        for (int i = 0; i < nums1.length; i++) {
            // 对于nums1中的数，因为nums2是递减的，
            // 所以倒着找，找到第一个 <= num1[i] 且 坐标k >= i的数，就是最大值
            for (int k = nums2.length - 1; k > 0; k--) {
                if (nums2[k] >= nums1[i]) {
                    int distance = k - i;
                    if (distance > maxDis) {
                        maxDis = distance;
                    }
                    break;
                } else {
                    if (k == 0) {
                        break;
                    }
                }
            }
        }
        return maxDis;
    }
}
