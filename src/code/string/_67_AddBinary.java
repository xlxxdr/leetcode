package code.string;

import tools.Asserts;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
Related Topics
位运算
数学
字符串
模拟
 */
public class _67_AddBinary {

	public static void main(String[] args) {
		_67_AddBinary app = new _67_AddBinary();
		Asserts.equals("10101", app.addBinary("1010", "1011"));
		Asserts.equals("101", app.addBinary("100", "1"));
		Asserts.equals("100000000", app.addBinary("11111111", "1"));
	}

	public String addBinary(String a, String b) {
		int zeroCount = 0;
		if (a.length() < b.length()) {
			zeroCount = b.length() - a.length();
			String zeros = "";
			for (int i = 0; i < zeroCount; i++) {
				zeros += "0";
			}
			a = zeros + a;
		} else if (a.length() > b.length()) {
			zeroCount = a.length() - b.length();
			String zeros = "";
			for (int i = 0; i < zeroCount; i++) {
				zeros += "0";
			}
			b = zeros + b;
		}
		int len = a.length() - 1;
		boolean carry = false;
		String newStr = "";
		while (len >= 0) {
			char ac = a.charAt(len);
			char bc = b.charAt(len);
			if (ac == '1' && bc == '1') {
				if (carry) {
					newStr = "1" + newStr;
					carry = true;
				} else {
					newStr = "0" + newStr;
					carry = true;
				}

			} else if (ac == '0' && bc == '0') {
				if (carry) {
					newStr = "1" + newStr;
					carry = false;
				} else {
					newStr = "0" + newStr;
				}
			} else {
				if (carry) {
					newStr = "0" + newStr;
					carry = true;
				} else {
					newStr = "1" + newStr;
				}

			}
			len--;
		}
		if (carry) {
			return "1" + newStr;
		}
		return newStr;
	}

}
