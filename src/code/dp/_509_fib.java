package code.dp;
//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//
//
// 给定 n ，请计算 F(n) 。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//
// 示例 3：
//
//
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 30
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 448 👎 0

import tools.Asserts;

public class _509_fib {

	public static void main(String[] args) {
		_509_fib app = new _509_fib();
		Asserts.equals(0, app.fib(0));
		Asserts.equals(1, app.fib(1));
		Asserts.equals(1, app.fib(2));
		Asserts.equals(2, app.fib(3));
		Asserts.equals(3, app.fib(4));
	}

	public int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		for (int i = 2; i <= n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}

	public int fib_recursion(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
