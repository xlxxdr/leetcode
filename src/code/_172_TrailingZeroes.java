package code;

import code.tools.Asserts;

public class _172_TrailingZeroes {

	public static void main(String[] args) {
		Asserts.equals(0,trailingZeroes(3));
		Asserts.equals(1,trailingZeroes(5));
		Asserts.equals(7,trailingZeroes(30));
		Asserts.equals(1704, trailingZeroes(6825));
		Asserts.equals(2499, trailingZeroes(10000));

	}

	public static int trailingZeroes(int n) {
		int zeroCount = 0;
		int nextFive = 5;
		int fiveCount = 0;
		int nextTen = 10;
		int tenCount = 0;
		boolean tenFlag = false;
		for (int i = 5; i <= n; i+=5) {
			if (i == nextTen) {
				tenFlag = true;
				tenCount++;
				zeroCount++;
				int temp = tenCount;
				while (temp % 5 == 0) {
					zeroCount++;
					temp = temp / 5;
				}
				nextTen = (tenCount + 1) * 10;
			}
			if (i == nextFive) {
				if (tenFlag) {
					tenFlag = false;
					fiveCount++;
					nextFive = (fiveCount + 1) * 5;
					continue;
				}
				fiveCount++;
				zeroCount++;
				int temp = fiveCount;
				while (temp % 5 == 0) {
					zeroCount++;
					temp = temp / 5;
				}
				nextFive = (fiveCount + 1) * 5;

			}
		}
		return zeroCount;
	}

	/**
	 * 1，2，3，4，5				=> 2 * 5 = 10 ==> 1
	 * 6，7，8，9，10			=> 10 ==> 1
	 * 11，12，13，14，15		=> 15 * 偶数 ==> 1
	 * 16，17，18，19，20		=> 20 ==> 1
	 * 21，22，23，24，25		=> 25 = 5 * 5 ==> (5 * 偶数) xx0 +  ( 5* 偶数 ) xx0 ==> 2
	 * 26，27，28，29，30		=> 30 ==》 1
	 * =========================================================
	 * 1 + 1 + 1 + 1 + 2 + 1 = 7
	 */
	public static int trailingZeroes_withTimeOut(int n) {
		int zero = 0;
		for (int i = 1; i <= n; i++) {
			double num = i;
			while (num != 0.0) {
				if (num % 5 == 0.0) {
					zero++;
					// System.out.println("i =  " + i + ",num: " + (int)num);
				}
				num = num / 5.0;
			}
		}
		return zero;
	}

}
