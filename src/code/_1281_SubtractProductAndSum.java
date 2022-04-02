package code;

import code.tools.Asserts;

public class _1281_SubtractProductAndSum {

	public static void main(String[] args) {
		Asserts.equals(0, subtractProductAndSum(1));
		Asserts.equals(-1,subtractProductAndSum(10));
		Asserts.equals(-1,subtractProductAndSum(1000000));
		Asserts.equals(15,subtractProductAndSum(234));
		Asserts.equals(21,subtractProductAndSum(4421));

	}

	public static int subtractProductAndSum(int n) {
		int flag = 0;
		int oriN = n;
		while (n != 0) {
			flag++;
			n = n / 10;
		}
		int sum = 0;
		int product = 1;
		for (int i = flag; i >= 1; i--) {
			if (i == 1) {
				sum += oriN;
				product *= oriN;
			} else {
				int pow = (int)Math.pow(10, i - 1);
				int num = oriN / pow;
				sum += num;
				product *= num;
				oriN = oriN - (num * pow);
			}
		}
		return product - sum;
	}
}
