package code;

import code.tools.Asserts;

public class _693_HasAlternatingBits {

	public static void main(String[] args) {
		_693_HasAlternatingBits func = new _693_HasAlternatingBits();
		Asserts.equalsTrue(func.hasAlternatingBits(1));
		Asserts.equalsTrue(func.hasAlternatingBits(2));
		Asserts.equalsFalse(func.hasAlternatingBits(3));
		Asserts.equalsTrue(func.hasAlternatingBits(5));
		Asserts.equalsFalse(func.hasAlternatingBits(7));
		Asserts.equalsFalse(func.hasAlternatingBits(11));
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
