package studyPlan.binarySearch.phase2;

import tools.Asserts;

import java.nio.charset.MalformedInputException;
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1172 👎 0

public class _209_minSubArrayLen extends Asserts {

    public static void main(String[] args) {
        _209_minSubArrayLen app = new _209_minSubArrayLen();
        equals(3, app.minSubArrayLen(11, getIntArray("[1,2,3,4,5]")));
        equals(0, app.minSubArrayLen(7, getIntArray("[2]")));
        equals(1, app.minSubArrayLen(2, getIntArray("[2]")));
        equals(2, app.minSubArrayLen(7, getIntArray("[2,3,1,2,4,3]")));
        equals(0, app.minSubArrayLen(11, getIntArray("[1,1,1,1,1,1,1,1]")));
        equals(1, app.minSubArrayLen(4, getIntArray("[1,4,4]")));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0;
        int end = 1;
        int minDis = Integer.MAX_VALUE;
        int sum = nums[0];
        if (sum >= target) {
            return 1;
        }
        while (begin != end && end < nums.length) {
            int beginVal = nums[begin];
            int endVal = nums[end];
            if (beginVal == target || endVal == target) {
                return 1;
            } else {
                //
                int tmpSum = sum + endVal;
                if (tmpSum < target){
                    sum = tmpSum;
                    end++;
                } else if (tmpSum >= target) {
                    int distance = end - begin + 1;
                    if (distance < minDis){
                        minDis = distance;
                    }
                    sum = tmpSum;
                    while (sum >= target) {
                        sum -= nums[begin++];
                        if (sum >= target) {
                            distance = end - begin + 1;
                            if (distance < minDis){
                                minDis = distance;
                            }
                        }
                    }
                    end++;
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? 0 : minDis;
    }
}
