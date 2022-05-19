package code.array;

import static tools.Asserts.*;

import tools.Asserts;
//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
//
// 例 1：
//
//
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释:
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
//
//
// 例 2：
//
//
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释:
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
//
//
// 注意：
//
//
// m 和 n 的范围在 [1, 30000] 之间。
// k 的范围在 [1, m * n] 之间。
//
// Related Topics 二分查找 👍 197 👎 0

public class _668_findKthNumber {

	public static void main(String[] args) {
		_668_findKthNumber app = new _668_findKthNumber();
		Asserts.equals(2, app.findKthNumber(2, 9, 3));
		Asserts.equals(3, app.findKthNumber(3, 3, 5));
		Asserts.equals(6, app.findKthNumber(2, 3, 6));
	}

	public int findKthNumber(int m, int n, int k) {
		int x = 1;
		int y = 1;
		for (int i = x; i <= m; i++) {
			for (int j = y; j <= n; j++) {
				k -= 2;
				if (k <= 0) {
					return i * j;
				}
			}
			for (int col = i + 1; col <= m; col++) {
				k--;
				if (k == 0) {
					return col * y;
				}
			}
			x++;
			y++;
		}
		return n;
	}

}
