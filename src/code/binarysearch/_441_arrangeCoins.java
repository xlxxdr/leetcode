package code.binarysearch;

//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
//
//
//
// 示例 1：
//
//
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
//
//
// 示例 2：
//
//
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 215 👎 0

import code.tools.Asserts;

public class _441_arrangeCoins {

    public static void main(String[] args) {
        _441_arrangeCoins app = new _441_arrangeCoins();
        Asserts.equals(2, app.arrangeCoins(5));
        Asserts.equals(2, app.arrangeCoins(3));
        Asserts.equals(3, app.arrangeCoins(8));
        Asserts.equals(65535, app.arrangeCoins(2147483647));
        Asserts.equals(1, app.arrangeCoins(1));

    }

    public int arrangeCoins(int n) {
        int right = 65536;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int sum = (1 + mid) * (mid >> 1);
            if (sum > n) {
                if (sum - mid - 1 < n) {
                    return mid - 1;
                }
                right = mid;
            } else if (sum < n) {
                int result = sum + mid + 1;
                if (result > n || result < 0) {
                    return mid;
                }
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int arrangeCoins1(int n) {
        int sum = 0;
        int line = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (sum < n && sum + i <= n) {
                sum += i;
                if (sum < 0) {
                    return line;
                }
                line++;
            } else {
                break;
            }
        }
        return line;
    }
}
