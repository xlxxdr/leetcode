package code.array;
//给你一个整数数组 nums ，该数组具有以下属性：
//
//
//
//
// nums.length == 2 * n.
// nums 包含 n + 1 个 不同的 元素
// nums 中恰有一个元素重复 n 次
//
//
// 找出并返回重复了 n 次的那个元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,3]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [2,1,2,5,3,2]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [5,1,5,2,5,3,5,4]
//输出：5
//
//
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5000
// nums.length == 2 * n
// 0 <= nums[i] <= 10⁴
// nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
//
// Related Topics 数组 哈希表 👍 120 👎 0

import tools.Asserts;

import java.util.*;

public class _961_repeatedNTimes {

    public static void main(String[] args) {
        _961_repeatedNTimes app = new _961_repeatedNTimes();
        Asserts.equals(3, app.repeatedNTimes(Asserts.getIntArray(1, 2, 3, 3)));
        Asserts.equals(2, app.repeatedNTimes(Asserts.getIntArray(2, 1, 2, 5, 3, 2)));
        Asserts.equals(5, app.repeatedNTimes(Asserts.getIntArray(5, 1, 5, 2, 5, 3, 5, 4)));

    }


    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public int repeatedNTimes2(int[] nums) {
        int n = nums.length >> 1;
        int count = 0;
        int firstPos = 0;
        int secondPos = 0;
        Arrays.sort(nums);
        // 当second指向最后一个元素时，结束循环
        while (secondPos != nums.length) {
            if (nums[secondPos] == nums[firstPos]) {
                // 如果相等，移动secondPos的坐标，指向下一个位置
                count++;
                secondPos++;
            } else {
                // 说明两个元素不相等，判断count是否等于n，等于就结束
                count = 0;
                firstPos = secondPos;
            }
            if (count == n) {
                return nums[firstPos];
            }
        }
        return 0;
    }

    public int repeatedNTimes1(int[] nums) {
        int n = nums.length >> 1;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
            if (countMap.get(num) == n) {
                return num;
            }
        }
        return 0;
    }
}
