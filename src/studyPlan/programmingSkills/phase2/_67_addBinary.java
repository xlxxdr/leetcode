package studyPlan.programmingSkills.phase2;

import tools.Asserts;

public class _67_addBinary extends Asserts {

	public static void main(String[] args) {
		_67_addBinary app = new _67_addBinary();
		equals("100", app.addBinary("1", "11"));
		equals("10101", app.addBinary("1010", "1011"));
		equals("11110", app.addBinary("1111", "1111"));
		equals("100", app.addBinary("11", "1"));
		equals("10101", app.addBinary("1010", "1011"));
		equals("10", app.addBinary("1", "1"));
		equals("1", app.addBinary("1", "0"));
		equals("0", app.addBinary("0", "0"));
	}

	public String addBinary(String a, String b) {
		int diffLen = a.length() - b.length();
		if (diffLen > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < diffLen; i++) {
				sb.append("0");
			}
			b = sb.append(b).toString();
		}
		if (diffLen < 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < diffLen * -1; i++) {
				sb.append("0");
			}
			a = sb.append(a).toString();
		}
		String result = "";
		boolean carry = false;
		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) == '1' && b.charAt(i) == '1') {
				if (carry) {
					result = "1" + result;
				} else {
					carry = true;
					result = "0" + result;
				}
			} else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
				if (carry) {
					result = "1" + result;
					carry = false;
				} else {
					result = "0" + result;
				}
			} else {
				// 0 1 ，1 0 的情况
				if (carry) {
					result = "0" + result;
				} else {
					result = "1" + result;
					carry = false;
				}
			}
		}
		return carry ? "1" + result : result;
	}

	public String addBinary1(String a, String b) {
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		String result = "";
		boolean carry = false;
		for (int i = aChars.length - 1, j = bChars.length - 1; i >= 0 && j >= 0; i--, j--) {
			if (aChars[i] == '1' && bChars[j] == '1') {
				if (carry) {
					result = "1" + result;
				} else {
					carry = true;
					result = "0" + result;
				}

			} else if (aChars[i] == '0' && bChars[j] == '0') {
				if (carry) {
					result = "1" + result;
					carry = false;
				} else {
					result = "0" + result;
				}
			} else {
				// 0 1 ，1 0 的情况
				if (carry) {
					result = "0" + result;
				} else {
					result = "1" + result;
					carry = false;
				}
			}
			if (i == 0 && j > 0) {
				// a的长度比b短，b还有一部分没有加完
				int flag = j - 1;
				for (int k = flag; k >= 0; k--) {
					if (carry) {
						if (bChars[k] == '1') {
							result = "0" + result;
						}
						if (bChars[k] == '0') {
							result = "1" + result;
							carry = false;
						}
					} else {
						result = bChars[k] + result;
					}
				}
				j = 0;
			}
			if (i > 0 && j == 0) {
				// a的长度比b长，a还有一部分没有加完
				// a的长度比b短，b还有一部分没有加完
				int flag = i - 1;
				for (int k = flag; k >= 0; k--) {
					if (carry) {
						if (aChars[k] == '1') {
							result = "0" + result;
						}
						if (aChars[k] == '0') {
							result = "1" + result;
							carry = false;
						}
					} else {
						result = aChars[k] + result;
					}
				}
				i = 0;
			}
		}
		return carry ? "1" + result : result;
	}

}
