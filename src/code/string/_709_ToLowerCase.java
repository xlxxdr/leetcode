package code.string;

import code.tools.Asserts;

public class _709_ToLowerCase {

	public static void main(String[] args) {
		_709_ToLowerCase app = new _709_ToLowerCase();
		Asserts.equals("hello",app.toLowerCase("Hello"));
		Asserts.equals("here",app.toLowerCase("here"));
		Asserts.equals("lovely",app.toLowerCase("LOVELY"));
	}

	public String toLowerCase(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'A' && chars[i] <= 'Z'){
				chars[i] = (char)((int)chars[i] + 32);
			}
		}
		return new String(chars);
	}
}
