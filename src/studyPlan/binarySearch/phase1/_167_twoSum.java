package studyPlan.binarySearch.phase1;

import tools.Asserts;

//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
//
// 你所设计的解决方案必须只使用常量级的额外空间。
//
//
// 示例 1：
//
//
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
//
// 示例 2：
//
//
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
//
// 示例 3：
//
//
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
//
//
//
//
// 提示：
//
//
// 2 <= numbers.length <= 3 * 10⁴
// -1000 <= numbers[i] <= 1000
// numbers 按 非递减顺序 排列
// -1000 <= target <= 1000
// 仅存在一个有效答案
//
// Related Topics 数组 双指针 二分查找 👍 786 👎 0
public class _167_twoSum {

	public static void main(String[] args) {
		_167_twoSum app = new _167_twoSum();
		Asserts.equals(new int[] {3, 4}, app.twoSum(new int[] {0, 0, 3, 3}, 6));
		Asserts.equals(new int[] {1, 2}, app.twoSum(new int[] {0, 0, 3, 4}, 0));
		Asserts.equals(new int[] {1, 2}, app.twoSum(new int[] {2, 7, 11, 15}, 9));
		Asserts.equals(new int[] {1, 3}, app.twoSum(new int[] {2, 3, 4}, 6));
		Asserts.equals(new int[] {1, 2}, app.twoSum(new int[] {-1, 0}, -1));

	}

	public int[] twoSum(int[] numbers, int target) {
		int pos1 = -1;
		int pos2 = -1;
		for (int i = 0; i < numbers.length; i++) {
			// 循环遍历每一个数，用target - 当前的数 得到新的目标值
			// newTarget =  target - numbers[i] 这样会将区间划分为两部分
			// 如果当前值大于 newTarget，则说明在左区间
			// 如果当前值小于 newTarget, 则说明在右区间
			int curVal = numbers[i];
			int newTarget = target - numbers[i];
			if (newTarget > curVal) {
				pos1 = i;
				pos2 = binarySearch(i + 1, numbers.length - 1, numbers, newTarget);
				if (pos2 != -1) {
					return new int[] {pos1 + 1, pos2 + 1};
				} else {
					continue;
				}
			}
			if (newTarget <= curVal) {
				pos2 = i;
				pos1 = binarySearch(0, i - 1, numbers, newTarget);
				if (pos1 != -1) {
					return new int[] {pos1 + 1, pos2 + 1};
				} else {
					continue;
				}
			}
		}
		return new int[] {-1, -1};
	}

	private int binarySearch(int begin, int end, int[] numbers, int newTarget) {
		int left = begin;
		int right = end;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (numbers[mid] == newTarget) {
				return mid;
			} else if (numbers[mid] < newTarget) {
				left = mid + 1;
			} else if (numbers[mid] > newTarget) {
				right = mid - 1;
			}
		}
		return -1;
	}
}
