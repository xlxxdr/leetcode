package code;

public class _344_ReverseString {

	public static void main(String[] args) {
		reverseString(new char[] {'a'});
		System.out.println();
		reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
		System.out.println();
		reverseString(new char[] {'H', 'a', 'n', 'n', 'a', 'h'});


	}

	public static void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left <= right) {
			char tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;
			left++;
			right--;
		}
		for (char c : s) {
			System.out.print((char)c);
			System.out.print(",");
		}
	}

}
