package code;

public class _557_ReverseWords {

	public static void main(String[] args) {
		System.out.println(reverseWords("a"));
		System.out.println(reverseWords("God"));
		System.out.println(reverseWords("hehhhhhhe"));
		System.out.println(reverseWords("God AAA"));
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int left = 0;
		int right = 0;
		for (char aChar : chars) {
			if (aChar != ' ') {
				right++;
			}
			if (aChar == ' ' || (right == s.length())) {
				int k = right - 1;
				while (left <= k) {
					char tmp = chars[left];
					chars[left] = chars[k];
					chars[k] = tmp;
					left++;
					k--;
				}
				right++;
				left = right;

			}
		}
		return new String(chars);
	}
}
