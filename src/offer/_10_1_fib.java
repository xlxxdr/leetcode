package offer;

import tools.Asserts;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//
//
// 示例 2：
//
//
//输入：n = 5
//输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 记忆化搜索 数学 动态规划 👍 367 👎 0
public class _10_1_fib extends Asserts {

    public static void main(String[] args) {
        _10_1_fib app = new _10_1_fib();
        equals(0, app.fib(0));
        equals(1, app.fib(1));
        equals(1, app.fib(2));
        equals(5, app.fib(5));
        equals(9227465, app.fib(35));
        equals(102334155, app.fib(40));
        equals(586268941, app.fib(50));
        equals(687995182, app.fib(100));

    }


    public int fib(int n) {
        int result = 0;
        int f0 = 0;
        int f1 = 1;
        if (n == 0 ) {
            return f0;
        }
        if (n == 1) {
            return f1;
        }
        for (int i = 2; i <= n; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
            if (f0 > 1000000007) {
                f0 = f0 % 1000000007;
            }
            if (f1 > 1000000007) {
                f1 = f1 % 1000000007;
            }
        }
        result = result % 1000000007;
        return result;
    }

    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
