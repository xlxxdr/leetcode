package code.array;
//给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//
// 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的
//字符 c 的 距离 。
//
// 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
//
//
//
// 示例 1：
//
//
//输入：s = "loveleetcode", c = "e"
//输出：[3,2,1,0,1,0,0,1,2,2,1,0]
//解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
//距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
//距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
//对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
//距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
//
//
// 示例 2：
//
//
//输入：s = "aaab", c = "b"
//输出：[3,2,1,0]
//
//
//
//提示：
//
//
// 1 <= s.length <= 10⁴
// s[i] 和 c 均为小写英文字母
// 题目数据保证 c 在 s 中至少出现一次
//
// Related Topics 数组 双指针 字符串 👍 236 👎 0

import code.tools.Asserts;

public class _821_shortestToChar {

	public static void main(String[] args) {
		_821_shortestToChar app = new _821_shortestToChar();
		Asserts.equals(new int[] {0,1,1,0}, app.shortestToChar("baab", 'b'));
		Asserts.equals(new int[] {1,0,1,2}, app.shortestToChar("abaa", 'b'));
		Asserts.equals(new int[] {2, 1, 0, 1}, app.shortestToChar("aaba", 'b'));
		Asserts.equals(new int[] {0}, app.shortestToChar("a", 'a'));
		Asserts.equals(new int[] {3, 2, 1, 0}, app.shortestToChar("aaab", 'b'));
		Asserts.equals(new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, app.shortestToChar("loveleetcode", 'e'));
	}

	public int[] shortestToChar(String s, char c) {
		int pos = 0;
		int prePos = 0;
		int[] result = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				prePos = pos;
				for (int k = pos; k < i; k++) {
					if (prePos != 0 || i == 0) {
						result[k] = Math.min(Math.abs(k - prePos), Math.abs(i - k));
					} else {
						result[k] = Math.abs(i - k);
					}
					pos++;
				}
			}
		}
		if (pos < s.length()) {
			for (int i = pos; i < s.length(); i++) {
				result[i] = Math.abs(i - pos);
			}
		}
		return result;
	}

}
