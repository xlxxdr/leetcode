package studyPlan.programmingSkills.phase2;

import tools.Asserts;
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。
//
// 说明：
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//
//
// 示例 1：
//
//
//输入：haystack = "hello", needle = "ll"
//输出：2
//
//
// 示例 2：
//
//
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
// Related Topics 双指针 字符串 字符串匹配 👍 1441 👎 0

public class _28_strStr extends Asserts {

	public static void main(String[] args) {
		_28_strStr app = new _28_strStr();
		// "mississippi"
		// "issipi"
		equals(	4, app.strStr("mississippi","issip"));
		equals(0, app.strStr("hello","hello"));
		equals(2, app.strStr("hello","ll"));
		equals(0, app.strStr("hello",""));
		equals(4, app.strStr("hello","o"));
		equals(0, app.strStr("hello","h"));
		equals(-1, app.strStr("aaaaa","bba"));
	}


	public int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		int needleLen = needle.length();
		int hayLen = haystack.length();
		if (needleLen > hayLen) {
			return -1;
		}
		if (haystack.equals(needle)) {
			return 0;
		}
		char fistChar = needle.charAt(0);
		char[] chars = haystack.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char aChar = chars[i];
			if (aChar == fistChar) {
				if (i + needleLen > hayLen) {
					return -1;
				}
				boolean find = true;
				for (int k = 1; k < needleLen; k++) {
					if (chars[i + k] != needle.charAt(k)) {
						find = false;
						break;
					}
				}
				if (find) {
					return i;
				}
			}
		}
		return -1;
	}
}
