package code.dp;

import tools.Asserts;
//泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//
//
// 示例 1：
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//
//
// 示例 2：
//
// 输入：n = 25
//输出：1389537
//
//
//
//
// 提示：
//
//
// 0 <= n <= 37
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
//
// Related Topics 记忆化搜索 数学 动态规划 👍 200 👎 0

public class _1137_tribonacci {

	public static void main(String[] args) {
		_1137_tribonacci app = new _1137_tribonacci();
		Asserts.equals(0, app.tribonacci(0));
		Asserts.equals(1, app.tribonacci(1));
		Asserts.equals(1, app.tribonacci(2));
		Asserts.equals(2, app.tribonacci(3));
		Asserts.equals(4, app.tribonacci(4));
		Asserts.equals(1389537, app.tribonacci(25));
	}

	public int tribonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (n == 2) {
			return 1;
		}
		int n1 = 0;
		int n2 = 1;
		int n3 = 1;
		int current = 0;
		for (int i = 3; i <= n; i++) {
			current = n1 + n2 + n3;
			n1 = n2;
			n2 = n3;
			n3 = current;
		}
		return current;
	}
}
