package code;

import code.tools.Asserts;

/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]
提示：

1 <= digits.length <= 100
0 <= digits[i] <= 9
 */
public class _66_PlusOne {

	/**
	 *陷阱
	 * 	* 存在进位问题
	 * 	* 存在数组增加一位，比如 9 -> 10
	 */
	public static void main(String[] args) {
		Asserts.equals("[9,9,0]", plusOne(new int[] {9, 8, 9}));
		Asserts.equals("[1,2,4]", plusOne(new int[] {1, 2, 3}));
		Asserts.equals("[1,0]", plusOne(new int[] {9}));
		Asserts.equals("[1,0,0]", plusOne(new int[] {9, 9}));
		Asserts.equals("[4,3,2,2]", plusOne(new int[] {4, 3, 2, 1}));
		Asserts.equals("[1]", plusOne(new int[] {0}));
		Asserts.equals("[9,0,0,0]", plusOne(new int[] {8, 9, 9, 9}));
	}

	public static int[] plusOne(int[] digits) {
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (carry == 1) {
				digits[i] = digits[i] + carry;
				if (digits[i] == 10) {
					digits[i] = 0;
					carry = 1;
				} else {
					// digits[i] = digits[i] + 1;
					carry = 0;
					break;
				}
			} else {
				if (digits[i] + 1 == 10) {
					digits[i] = 0;
					carry = 1;
				} else {
					digits[i] = digits[i] + 1;
					break;
				}
			}

		}
		if (carry == 1) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = carry;
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			return newDigits;
		} else {
			return digits;
		}
	}

}
