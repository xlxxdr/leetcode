package _2022_06_01;

import tools.Asserts;
//给定一个整数数组 nums，处理以下类型的多个查询:
//
//
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
//
//
// 实现 NumArray 类：
//
//
// NumArray(int[] nums) 使用数组 nums 初始化对象
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
//
//
//
//
// 示例 1：
//
//
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁵ <= nums[i] <= 10⁵
// 0 <= i <= j < nums.length
// 最多调用 10⁴ 次 sumRange 方法
//
// Related Topics 设计 数组 前缀和 👍 467 👎 0

public class _303_NumArray extends Asserts {

	public static void main(String[] args) {
		_303_NumArray app = new _303_NumArray();

		NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		equals(1, numArray.sumRange(0, 2)); // return 1 ((-2) + 0 + 3)
		equals(-1, numArray.sumRange(2, 5)); // return -1 (3 + (-5) + 2 + (-1))
		equals(-3, numArray.sumRange(0, 5)); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

	}

	static class NumArray {

		int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
		}

		public int sumRange(int left, int right) {
			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += nums[i];
			}
			return sum;
		}
	}
}

