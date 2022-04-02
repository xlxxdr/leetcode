package code;

public class _191_HammingWeight {

	public static void main(String[] args) {

		System.out.println(hammingWeight(00000000000000000000000000001011));
		System.out.println(hammingWeight(00000000000000000000000010000000));
		// System.out.println(hammingWeight(11111111111111111111111111111101));
	}
	//
	// public static int hammingWeight(int n) {
	// 	String s = Integer.toBinaryString(n);
	// 	char[] chars = s.toCharArray();
	// 	int count = 0;
	// 	for (char aChar : chars) {
	// 		if (aChar == '1') {
	// 			count++;
	// 		}
	// 	}
	// 	return count;
	// }

	public static int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			int bit = n & 1;
			if (bit == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
}
