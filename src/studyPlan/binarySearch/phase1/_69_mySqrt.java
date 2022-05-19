package studyPlan.binarySearch.phase1;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
// 示例 1：
//
//
//输入：x = 4
//输出：2
//
//
// 示例 2：
//
//
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//
//
// 提示：
//
//
// 0 <= x <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 1003 👎 0

import tools.Asserts;

public class _69_mySqrt {

	public static void main(String[] args) {
		_69_mySqrt app = new _69_mySqrt();
		Asserts.equals(0, app.mySqrt(0));
		Asserts.equals(2, app.mySqrt(4));
		Asserts.equals(2, app.mySqrt(8));
		Asserts.equals(46340, app.mySqrt(2147483647));
	}

	public int mySqrt(int x) {
		int left = 0;
		int right = 46341;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			int rev = mid * mid;
			if (rev < 0) {
				return mid - 1;
			}
			if (rev == x) {
				return mid;
			}
			if (rev > x) {
				if ((mid - 1) * (mid - 1) < x){
					return mid - 1;
				}
				right = mid - 1;
			}
			if (rev < x) {
				if ((mid + 1) * (mid + 1) > x){
					return mid;
				}
				left = mid + 1;
			}

		}
		return -1;
	}

	public int mySqrt1(int x) {
		boolean lower = true;
		for (int i = 1; i <= 46341; i++) {
			int result = i * i;
			if (result == x) {
				return i;
			}
			if ((result > x && lower) || result < 0) {
				return i - 1;
			}
		}
		return -1;
	}

}
