package code;

public class _567_CheckInclusion {

	public static void main(String[] args) {
		checkInclusion("ab", "eidbaooo");
		checkInclusion("ab", "eidboaoo");
	}

	public static boolean checkInclusion(String s1, String s2) {
		char[] s2Charts = s2.toCharArray();
		char[] s1Charts = s1.toCharArray();
		int s2Begin = s1Charts.length;
		int s2End = s2Charts.length - s1Charts.length;

		int count = 0;
		for (int i = s2Begin; i < s2End; i++) {
			for (char s1Chart : s1Charts) {
				if (s1Chart == s2Charts[i]) {
					// 找到了s1中的字符，说明可能存在[s1]
				}
			}
		}
		return false;
	}
}
