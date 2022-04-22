package code.string;

import code.tools.Asserts;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 */
public class _14_LongestCommonPrefix {

	public static void main(String[] args) {
		_14_LongestCommonPrefix app = new _14_LongestCommonPrefix();
		Asserts.equals("flower", app.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
		Asserts.equals("a", app.longestCommonPrefix(new String[]{"ab","a"}));
		Asserts.equals("", app.longestCommonPrefix(new String[]{"",""}));
		Asserts.equals("", app.longestCommonPrefix(new String[]{"ab",""}));
		Asserts.equals("fl", app.longestCommonPrefix(new String[]{"flower","flow","flight"}));
		Asserts.equals("", app.longestCommonPrefix(new String[]{"dog","racecar","car"}));
	}

	public String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if (strs.length == 1) {
			return strs[0];
		}
		String candidate = strs[0];
		if (candidate.isEmpty()){
			return "";
		}
		char f = candidate.charAt(0);
		int j = 0;
		while (f != ' ' && j < candidate.length()) {
			boolean same = true;
			for (int i = 1; i < strs.length; i++) {
				String str = strs[i];
				if (str.isEmpty()){
					return "";
				}
				if (j >= str.length()){
					return prefix;
				}
				if (str.charAt(j) != f) {
					f = ' ';
					same = false;
					break;
				}
			}
			if (same){
				j++;
				prefix += f;
				if (j == candidate.length()){
					return prefix;
				}
				f = candidate.charAt(j);
			}

		}
		return prefix;
	}

}
