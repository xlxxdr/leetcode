package studyPlan.programmingSkills.phase2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tools.Asserts;

//整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。
//
//
// 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
//
//
// 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：num = [1,2,0,0], k = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
//
//
// 示例 2：
//
//
//输入：num = [2,7,4], k = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
//
//
// 示例 3：
//
//
//输入：num = [2,1,5], k = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
//
//
//
//
// 提示：
//
//
// 1 <= num.length <= 10⁴
// 0 <= num[i] <= 9
// num 不包含任何前导零，除了零本身
// 1 <= k <= 10⁴
//
// Related Topics 数组 数学 👍 203 👎 0
public class _989_addToArrayForm extends Asserts {

	public static void main(String[] args) {
		_989_addToArrayForm app = new _989_addToArrayForm();
		//[8,8,9]
		// 16
		equals(getIntList("[9,0,5]"), app.addToArrayForm(getIntArray("[8,8,9]"), 16));
		equals(getIntList("[4,5,5]"), app.addToArrayForm(getIntArray("[2,7,4]"), 181));
		//[9,9,9,9,9,9,9,9,9,9]
		// 1
		equals(getIntList("[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]"), app.addToArrayForm(getIntArray("[9,9,9,9,9,9,9,9,9,9]"), 1));
		equals(getIntList("[1]"), app.addToArrayForm(getIntArray("[0]"), 1));
		equals(getIntList("[1,2,3,4]"), app.addToArrayForm(getIntArray("[1,2,0,0]"), 34));
		equals(getIntList("[1,0,2,1]"), app.addToArrayForm(getIntArray("[2,1,5]"), 806));
	}


	public List<Integer> addToArrayForm(int[] num, int k) {
		// k 不存在负数的情况
		byte carry = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = num.length - 1; i >= 0; i--) {
			if (k != 0) {
				int val = num[i] + (k % 10);
				if (carry == 1) {
					// 不存在carry等于2的情况，因为9 + 9 = 18 --> 18加进位1最大19
					if (val + carry >= 10) {
						carry = 1;
						result.add( (carry + val) % 10);
					} else {
						result.add(carry + val);
						carry = 0;
					}
				} else {
					// 没有进位
					if (val >= 10) {
						result.add( val % 10);
						carry = 1;
					} else {
						result.add( val);
					}
				}
				k = k / 10;
			} else {
				// k的位数比nums短
				if (i >= 0) {
					for (int j = i; j >= 0; j--) {
						if (carry == 1) {
							int n = num[j] + carry;
							if (n >= 10) {
								result.add( n % 10);
								carry = 1;
							} else {
								result.add( n);
								carry = 0;
							}
						} else {
							// 不可能存在大于10的情况，因为每个元素的取值范围是0-9
							result.add( num[j]);
						}
					}
				}
				break;
			}
			if (i == 0) {
				//k的位数比nums长
				while (k > 0) {
					if (carry == 1) {
						int n = k % 10 + carry;
						if (n >= 10) {
							result.add( n % 10);
						} else {
							result.add( n);
							carry = 0;
						}

					} else {
						result.add(k % 10);
					}
					k = k / 10;
				}
			}
		}
		if (carry == 1) {
			result.add( 1);
		}
		Collections.reverse(result);
		return result;
	}

	public List<Integer> addToArrayForm2(int[] num, int k) {
		// k 不存在负数的情况
		byte carry = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = num.length - 1; i >= 0; i--) {
			if (k != 0) {
				int val = num[i] + (k % 10);
				if (carry == 1) {
					// 不存在carry等于2的情况，因为9 + 9 = 18 --> 18加进位1最大19
					if (val + carry >= 10) {
						carry = 1;
						result.add(0, (carry + val) % 10);
					} else {
						result.add(0, carry + val);
						carry = 0;
					}
				} else {
					// 没有进位
					if (val >= 10) {
						result.add(0, val % 10);
						carry = 1;
					} else {
						result.add(0, val);
					}
				}
				k = k / 10;
			} else {
				// k的位数比nums短
				if (i >= 0) {
					for (int j = i; j >= 0; j--) {
						if (carry == 1) {
							int n = num[j] + carry;
							if (n >= 10) {
								result.add(0, n % 10);
								carry = 1;
							} else {
								result.add(0, n);
								carry = 0;
							}
						} else {
							// 不可能存在大于10的情况，因为每个元素的取值范围是0-9
							result.add(0, num[j]);
						}
					}
				}
				break;
			}
			if (i == 0) {
				//k的位数比nums长
				while (k > 0) {
					if (carry == 1) {
						int n = k % 10 + carry;
						if (n >= 10) {
							result.add(0, n % 10);
						} else {
							result.add(0, n);
							carry = 0;
						}

					} else {
						result.add(0, k % 10);
					}
					k = k / 10;
				}
			}
		}
		if (carry == 1) {
			result.add(0, 1);
		}
		return result;
	}

	public List<Integer> addToArrayForm1(int[] num, int k) {
		// k 不存在复数的情况
		int sum = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			sum += num[i] * Math.pow(10, num.length - (i + 1));
		}
		sum += k;
		List<Integer> result = new ArrayList<>();
		while (sum != 0) {
			result.add(0, sum % 10);
			sum = sum / 10;
		}
		return result;
	}
}
