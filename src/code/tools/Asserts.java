package code.tools;

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
			throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
		}
		for (int i = 0; i < expect.length; i++) {
			if (expect[i] != actual[i]) {
				throw new IllegalStateException("expect: " + expect + ",actual: " + actual);
			}
		}
	}

	public static void equals(String expect, int[] actual) {
		String actualStr = PrintTool.printArray(actual);
		if (!expect.equals(actualStr)) {
			throw new IllegalStateException("expect: " + expect + ",actual: " + actualStr);
		}

	}

	public static void equalsTrue(boolean state) {
		if (!state) {
			throw new IllegalStateException("expect: true,actual: false");
		}
	}

	public static void equalsFalse(boolean state) {
		if (state) {
			throw new IllegalStateException("expect: false,actual: true");
		}
	}

}
