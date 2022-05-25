package offer;

import java.util.Arrays;

import tools.Asserts;
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 284 👎 0

public class _39_majorityElement extends Asserts {

	public static void main(String[] args) {
		_39_majorityElement app = new _39_majorityElement();
		equals(2,app.majorityElement(getIntArray("[1, 2, 3, 2, 2, 2, 5, 4, 2]")));
	}

	// 解题思路
	// 既然都超过一半了，那么排序后中间的那个数就是他
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length >> 1];
	}
}