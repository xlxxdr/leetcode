package code.tools;

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
