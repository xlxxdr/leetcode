package interview;

import tools.Asserts;

// 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
// 	示例 1:
//
// 	输入:
// 	first = "pale"
// 	second = "ple"
// 	输出: True
// 	示例 2:
//
// 	输入:
// 	first = "pales"
// 	second = "pal"
// 	输出: False
// 	Related Topics
// 	双指针
// 	字符串
public class _01_05_oneEditAway {

	public static void main(String[] args) {
		_01_05_oneEditAway app = new _01_05_oneEditAway();
		Asserts.isFalse(app.oneEditAway("teacher", "bleacher"));
		Asserts.isFalse(app.oneEditAway("mart", "karma"));
		Asserts.isFalse(app.oneEditAway("intention", "execution"));
		Asserts.isTrue(app.oneEditAway("pale", "pal"));
		Asserts.isFalse(app.oneEditAway("palee", "pal"));
		Asserts.isFalse(app.oneEditAway("pales", "pal"));
		Asserts.isTrue(app.oneEditAway("ale", "pale"));
		Asserts.isTrue(app.oneEditAway("a", "a"));
	}

	public boolean oneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		if (first.equals(second)) {
			// 完全相等0次编辑
			return true;
		} else {
			// 1次编辑
			// first.length = second.length --> 只能在同一个位置，有一个字符允许不同
			if (first.length() == second.length()) {
				int diff = 0;
				for (int i = 0; i < first.length(); i++) {
					if (first.charAt(i) != second.charAt(i)) {
						diff++;
						if (diff > 1){
							return false;
						}
					}
				}
				if (diff == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				// first.length > second.length --> 允许长度长的减掉差异字符后，两者完全相等
				// first.length < second.length
				String longStr;//存储长度长的字符串
				String shortStr;//存储长度端的字符串
				if (first.length() > second.length()) {
					longStr = first;
					shortStr = second;
				} else {
					longStr = second;
					shortStr = first;
				}
				int diff = 0;
				int latestLongPos = -1;
				for (int i = 0, j = 0; i < shortStr.length() && j < longStr.length(); i++, j++) {
					if (shortStr.charAt(i) != longStr.charAt(j)) {
						i--;
						diff++;
						if (diff > 1){
							return false;
						}
					}
					latestLongPos = j;
				}
				if (diff == 1 || (diff == 0 && latestLongPos == longStr.length() - 2)) { // 减2是因为下标从0开始的
					return true;
				} else {
					return false;
				}
			}
		}
	}

}
