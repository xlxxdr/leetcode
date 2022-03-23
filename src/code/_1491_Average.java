package code;

import code.tools.Asserts;

public class _1491_Average {

    public static void main(String[] args) {
        Asserts.equals(3500.00000, average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        Asserts.equals(3888.50000, average(new int[]{6000, 5555, 4444, 3333, 2222, 1000}));
        Asserts.equals(4750.00000, average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }

    public static double average(int[] salary) {
        if (salary.length < 3 && salary.length > 100){
            return 0D;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int s : salary) {
            sum += s;
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        return (sum - max - min) * 1.0 / (salary.length - 2);

    }

}
