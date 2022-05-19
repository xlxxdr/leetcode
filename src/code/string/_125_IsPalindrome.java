package code.string;

import tools.Asserts;

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2:

输入: "race a car"
输出: false
解释："raceacar" 不是回文串
提示：

1 <= s.length <= 2 * 105
字符串 s 由 ASCII 字符组成
Related Topics
双指针
字符串
 */
public class _125_IsPalindrome {

	public static void main(String[] args) {
		_125_IsPalindrome app = new _125_IsPalindrome();
		Asserts.isTrue(app.isPalindrome("AA"));
		Asserts.isTrue(app.isPalindrome("A"));
		Asserts.isTrue(app.isPalindrome("010"));
		Asserts.isTrue(app.isPalindrome("A man, a plan, a canal: Panama"));
		Asserts.isFalse(app.isPalindrome("race a car"));
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		if (s.length() == 1) {
			return true;
		}
		char[] chars = s.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right){
			if (!Character.isDigit(chars[left]) && !Character.isAlphabetic(chars[left])){
				left++;
				continue;
			}
			if (!Character.isDigit(chars[right]) && !Character.isAlphabetic(chars[right])){
				right--;
				continue;
			}
			if (chars[left] != chars[right]){
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}
}
