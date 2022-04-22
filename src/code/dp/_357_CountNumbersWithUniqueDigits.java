package code.dp;

import java.util.HashSet;
import java.util.Set;

import code.tools.Asserts;

public class _357_CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		_357_CountNumbersWithUniqueDigits app = new _357_CountNumbersWithUniqueDigits();
		Asserts.equals(1,app.countNumbersWithUniqueDigits(0));
		Asserts.equals(10,app.countNumbersWithUniqueDigits(1));
		Asserts.equals(91,app.countNumbersWithUniqueDigits(2));
		Asserts.equals(739,app.countNumbersWithUniqueDigits(3));
	}

	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		if (n == 2) {
			return 91;
		}
		int max = (int)Math.pow(10, n);
		int total = 91;
		for (int i = 101; i <= max; i++) {
			Set<Integer> digits = new HashSet<>();
			int num = i;
			boolean breakFlag = false;
			while (num != 0) {
				int d = num % 10;
				if (digits.contains(d)){
					breakFlag = true;
					break;
				}
				digits.add(d);
				num = num / 10;
			}
			if (!breakFlag){
				total ++;
			}
		}
		return total;
	}

}
