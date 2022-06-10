package studyPlan.algorithms.phase1;

import tools.Asserts;
//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：true
//解释：2⁰ = 1
//
//
// 示例 2：
//
//
//输入：n = 16
//输出：true
//解释：2⁴ = 16
//
//
// 示例 3：
//
//
//输入：n = 3
//输出：false
//
//
// 示例 4：
//
//
//输入：n = 4
//输出：true
//
//
// 示例 5：
//
//
//输入：n = 5
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
// Related Topics 位运算 递归 数学 👍 502 👎 0

public class _231_isPowerOfTwo extends Asserts {

	public static void main(String[] args) {
		_231_isPowerOfTwo app = new _231_isPowerOfTwo();
		isFalse(app.isPowerOfTwo(-2147483648));
		isTrue(app.isPowerOfTwo(1));
		isTrue(app.isPowerOfTwo(2));
		isTrue(app.isPowerOfTwo(4));
		isTrue(app.isPowerOfTwo(8));
		isTrue(app.isPowerOfTwo(1024));
		isFalse(app.isPowerOfTwo(5));
	}

	//
	public boolean isPowerOfTwo(int n) {
		if (n < 0) {
			return false;
		}
		int count = 0;
		// 解题思路：
		// 2的幂次方的数其二进制只能有一位为1
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				count++;
				if (count > 1) {
					return false;
				}
			}
			n = n >> 1;
		}
		return count == 1;
	}

}
