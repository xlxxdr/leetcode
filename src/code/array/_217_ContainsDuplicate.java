package code.array;

import java.util.HashMap;

import code.tools.Asserts;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * Related Topics
 * 数组
 * 哈希表
 * 排序
 */
public class _217_ContainsDuplicate {

	public static void main(String[] args) {
		Asserts.equalsTrue(containsDuplicate(new int[] {1, 2, 3, 1}));
		Asserts.equalsFalse(containsDuplicate(new int[] {1, 2, 3, 4}));
		Asserts.equalsTrue(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}

	public static boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.putIfAbsent(num, num) != null) {
				return true;
			}
		}
		return false;
	}
}
