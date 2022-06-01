package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Asserts {

	public static void equals(int expect, int actual) {
		if (expect != actual) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}
	}

	public static void equals(double expect, double actual) {
		if (expect != actual) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}
	}

	public static void equals(String expect, String actual) {
		if (!Objects.equals(expect, actual)) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}
	}

	public static void equals(List<Integer> expect, List<Integer> actual) {
		if (!expect.equals(actual)) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}
	}

	public static void equals(int[] expect, int[] actual) {
		if (expect.length != actual.length) {
			throw new IllegalStateException("expect: " + Arrays.toString(expect) + ",actual: " + Arrays.toString(actual));
		}
		for (int i = 0; i < expect.length; i++) {
			if (expect[i] != actual[i]) {
				throw new IllegalStateException("expect: " + Arrays.toString(expect) + ",actual: " + Arrays.toString(actual));
			}
		}
	}

	public static void equals(int[][] expect, int[][] actual) {
		if (expect.length != actual.length) {
			throw new IllegalStateException("expect: " + Arrays.toString(expect) + ",actual: " + Arrays.toString(actual));
		}
		int col = expect[0].length;
		for (int i = 0; i < expect.length; i++) {
			for (int j = 0; j < col; j++) {
				if (expect[i][j] != actual[i][j]) {
					throw new IllegalStateException("expect(" + i + "," + j + "): " + expect[i][j] + ",actual(" + i + "," + j + "): " + actual[i][j]);

				}
			}

		}
	}

	public static void equals(String expect, int[] actual) {
		String actualStr = PrintTool.printArray(actual);
		if (!expect.equals(actualStr)) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actualStr);
		}

	}

	public static void equals(ListNode expect, ListNode actual) {
		if (expect.val != actual.val) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}

	}

	public static void isTrue(boolean state) {
		if (!state) {
			throw new IllegalStateException("expect: true,actual: false");
		}
	}

	public static void isFalse(boolean state) {
		if (state) {
			throw new IllegalStateException("expect: false,actual: true");
		}
	}

	public static String[] getStringArray(String... strings) {
		if (strings.length == 0) {
			throw new IllegalStateException("string should not be null");
		}
		return strings;
	}

	public static int[] getIntArray(int... nums) {
		if (nums.length == 0) {
			throw new IllegalStateException("num should not be null");
		}
		return nums;
	}

	public static int[] getIntArray(String numStr) {
		numStr = numStr.replaceAll(" ", "");
		numStr = numStr.substring(1, numStr.length() - 1);
		String[] nums = numStr.split(",");
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = Integer.parseInt(nums[i]);
		}
		return result;
	}

	public static List<Integer> getIntList(String str) {
		str = str.trim().substring(1, str.length() - 1);
		String[] nums = str.split(",");
		List<Integer> numList = new ArrayList<>();
		for (String num : nums) {
			numList.add(Integer.parseInt(num.trim()));
		}
		return numList;
	}

	public static int[][] getInt2DArrayFromString(String numStr) {
		numStr = numStr.substring(2, numStr.length() - 2);
		String[] split = numStr.split("],\\[");
		int row = split.length;
		int[][] result = new int[row][];
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			String[] nums = s.split(",");
			int[] items = new int[nums.length];
			for (int k = 0; k < nums.length; k++) {
				items[k] = Integer.parseInt(nums[k]);
			}
			result[i] = items;
		}
		return result;
	}

}
