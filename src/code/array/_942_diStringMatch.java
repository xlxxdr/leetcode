package code.array;

import tools.Asserts;

//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
//
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//
//
// 示例 1：
//
//
//输入：s = "IDID"
//输出：[0,4,1,3,2]
//
//
// 示例 2：
//
//
//输入：s = "III"
//输出：[0,1,2,3]
//
//
// 示例 3：
//
//
//输入：s = "DDI"
//输出：[3,2,0,1]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含字符 "I" 或 "D"
//
// Related Topics 贪心 数组 数学 双指针 字符串 👍 288 👎 0
public class _942_diStringMatch {

	public static void main(String[] args) {
		_942_diStringMatch app = new _942_diStringMatch();
		Asserts.equals(new int[] {0, 4, 1, 3, 2}, app.diStringMatch("IDID"));
		Asserts.equals(new int[] {0, 1, 2, 3}, app.diStringMatch("III"));
		Asserts.equals(new int[] {3,2,0,1}, app.diStringMatch("DDI"));

	}

	public int[] diStringMatch(String s) {
		int[] result = new int[s.length() + 1];
		int iNum = 0;
		int dNum = s.length();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I') {
				result[i] = iNum++;
				if (i == s.length() - 1) {
					result[++i] = iNum;
				}
			}
			if (c == 'D') {
				result[i] = dNum--;
				if (i == s.length() - 1) {
					result[++i] = dNum;
				}
			}
		}
		return result;
	}

}
