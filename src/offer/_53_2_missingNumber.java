package offer;

import tools.Asserts;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
//输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 271 👎 0
public class _53_2_missingNumber extends Asserts {

    public static void main(String[] args) {
        _53_2_missingNumber app = new _53_2_missingNumber();
        equals(1, app.missingNumber(getIntArray(0)));
        equals(2, app.missingNumber(getIntArray(0, 1, 3)));
        equals(8, app.missingNumber(getIntArray(0,1,2,3,4,5,6,7,9)));
    }

    // 解题思路：
    // 数组长度：n -1,实际应该是n
    // 数字范围:0~n-1
    // 递增排序的数组，所以数字内容刚好对应下标，遍历一遍，找到不在对应位置的就是确实的数字
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        // 如果都扫描了一遍还没有出结果，说明缺失的是最有一个数
        return nums.length;
    }
}
