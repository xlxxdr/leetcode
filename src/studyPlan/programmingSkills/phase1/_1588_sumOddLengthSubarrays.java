package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//
// 子数组 定义为原数组中的一个连续子序列。
//
// 请你返回 arr 中 所有奇数长度子数组的和 。
//
//
//
// 示例 1：
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
//
// 示例 2：
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
//
// 示例 3：
//
// 输入：arr = [10,11,12]
//输出：66
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 100
// 1 <= arr[i] <= 1000
//
// Related Topics 数组 数学 前缀和 👍 184 👎 0
public class _1588_sumOddLengthSubarrays extends Asserts {

	public static void main(String[] args) {
		_1588_sumOddLengthSubarrays app = new _1588_sumOddLengthSubarrays();
		equals(1,app.sumOddLengthSubarrays(getIntArray(1)));
		equals(3,app.sumOddLengthSubarrays(getIntArray(1,2)));
		equals(12,app.sumOddLengthSubarrays(getIntArray(1,2,3)));
		equals(66,app.sumOddLengthSubarrays(getIntArray(10,11,12)));
		equals(58,app.sumOddLengthSubarrays(getIntArray(1,4,2,5,3)));
	}

	public int sumOddLengthSubarrays(int[] arr) {
		int step = 1;
		int sum = 0;
		while (step <= arr.length) {
			int begin = 0;
			int end = begin + step;
			while (end <= arr.length) {
				for (int i = begin; i < end; i++) {
					sum += arr[i];
				}
				begin++;
				end = begin + step;
			}
			step += 2;
		}
		return sum;
	}

}
