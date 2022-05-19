package code;

import tools.Asserts;

public class _693_HasAlternatingBits {

	public static void main(String[] args) {
		_693_HasAlternatingBits func = new _693_HasAlternatingBits();
		Asserts.isTrue(func.hasAlternatingBits(1));
		Asserts.isTrue(func.hasAlternatingBits(2));
		Asserts.isFalse(func.hasAlternatingBits(3));
		Asserts.isTrue(func.hasAlternatingBits(5));
		Asserts.isFalse(func.hasAlternatingBits(7));
		Asserts.isFalse(func.hasAlternatingBits(11));
	}

	public boolean hasAlternatingBits(int n) {
		String nStr = Integer.toBinaryString(n);
		char[] chars = nStr.toCharArray();
		if (chars.length == 1) {
			return true;
		}
		int left = 0;
		int right = 1;
		while (right != chars.length) {
			if (chars[left] == chars[right]) {
				return false;
			}
			left++;
			right++;
		}
		return true;
	}

}
