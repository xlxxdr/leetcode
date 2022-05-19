package code.binarysearch;
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。
//
//
//
// 示例 1：
//
//
//输入：num = 16
//输出：true
//
//
// 示例 2：
//
//
//输入：num = 14
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics 数学 二分查找 👍 384 👎 0

import tools.Asserts;

public class _367_isPerfectSquare {

	public static void main(String[] args) {
		_367_isPerfectSquare app = new _367_isPerfectSquare();
		Asserts.isTrue(app.isPerfectSquare(808201));
		Asserts.isTrue(app.isPerfectSquare(1));
		Asserts.isTrue(app.isPerfectSquare(16));
		Asserts.isFalse(app.isPerfectSquare(12));
		Asserts.isFalse(app.isPerfectSquare(14));
		Asserts.isFalse(app.isPerfectSquare(2147483647));

	}

	public boolean isPerfectSquare(int num) {
		for (int i = 1; i < 1000; i++) {
			int result = i * i;
			if (result == num) {
				return true;
			} else if (result > num){
				return false;
			}
		}
		return false;
	}

	public boolean isPerfectSquare2(int num) {
		if (num == 1) {
			return true;
		}
		int left = 1;
		int right = num >> 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			int result = mid * mid;
			if (result == num) {
				return true;
			} else if (result > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	public boolean isPerfectSquare1(int num) {
		int left = 1;
		int right = num;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			int result = mid * mid;
			if (result == num) {
				return true;
			} else if (result > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

}
