package offer;

import static tools.Asserts.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//找出数组中重复的数字。
//
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
// [2, 3, 1, 0, 2, 5, 3]
// 输出：2 或 3
public class _03_findRepeatNumber {

	public static void main(String[] args) {
		_03_findRepeatNumber app = new _03_findRepeatNumber();
		System.out.println(app.findRepeatNumber(getIntArray(2, 3, 1, 0, 2, 5, 3)));

	}

	public int findRepeatNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1) {
			return -1;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return nums[i];
			}
		}
		return -1;
	}

	public int findRepeatNumber1(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			if (numMap.getOrDefault(num, -1) != -1) {
				return num;
			} else {
				numMap.put(num, 1);
			}
		}
		return -1;
	}
}
