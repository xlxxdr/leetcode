package code.string;

import tools.Asserts;

/*
给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。

s 的 旋转操作 就是将 s 最左边的字符移动到最右边。

例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
示例 1:

输入: s = "abcde", goal = "cdeab"
输出: true
示例 2:

输入: s = "abcde", goal = "abced"
输出: false
提示:

1 <= s.length, goal.length <= 100
s 和 goal 由小写英文字母组成
Related Topics
字符串
字符串匹配
 */
public class _796_RotateString {

	public static void main(String[] args) {
		_796_RotateString app = new _796_RotateString();
		Asserts.isTrue(app.rotateString("abcde", "cdeab"));
		Asserts.isTrue(app.rotateString("ddddd", "ddddd"));
		Asserts.isFalse(app.rotateString("abcde", "abced"));

	}

	/**
	 * 根据第一个字符的位置将原字符串切割为左边和右边
	 * 右边 + 左边 等于目标字符串则正确
	 * 否则继续寻找目标字符串中第一个字符出现的位置
	 * @param s
	 * @param goal
	 * @return
	 */
	public boolean rotateString(String s, String goal) {
		char firstChar = goal.charAt(0);
		int begin = s.indexOf(firstChar);
		while (begin != -1) {
			String left = s.substring(0, begin);
			String right = s.substring(begin);
			if ((right + left).equals(goal)){
				return true;
			} else {
				begin = s.indexOf(firstChar,begin + 1);
			}
		}
		return false;
	}

}
