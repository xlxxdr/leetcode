package code;

import tools.Asserts;

import java.util.Stack;

public class _682_CalPoints {

    public static void main(String[] args) {

        Asserts.equals(-175, calPoints(new String[]{"1", "C", "-62", "-45", "-68"}));
        Asserts.equals(219, calPoints(new String[]{"36", "28", "70", "65", "C", "+", "33", "-46", "84", "C"}));
        Asserts.equals(15, calPoints(new String[]{"1", "D", "D", "D"}));
        Asserts.equals(0, calPoints(new String[]{"1", "C", "D", "D"}));
        Asserts.equals(1, calPoints(new String[]{"1"}));
        Asserts.equals(30, calPoints(new String[]{"5", "2", "C", "D", "+"}));
        Asserts.equals(27, calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                Integer item = stack.pop();
                sum -= item;
                if (stack.isEmpty()){
                    stack.push(0);
                }
            } else if (op.equals("D")) {
                Integer item = stack.lastElement();
                int newValue = item * 2;
                sum += newValue;
                stack.push(newValue);
            } else if (op.equals("+")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int newValue = num1 + num2;
                sum += newValue;
                stack.push(num2);
                stack.push(num1);
                stack.push(newValue);
            } else {
                Integer item = Integer.valueOf(op);
                stack.push(item);
                sum += item;
            }
        }
        return sum;
    }


    public static int calPointsFailed(String[] ops) {
        if (ops.length == 1) {
            return Integer.valueOf(ops[0]);
        }
        String C = "C";
        String D = "D";
        String add = "+";
        int firstNonZero = 0;
        int secondNonZero = 0;
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String current = ops[i];
            if (!current.equals(C) && !current.equals(D) && !current.equals(add)) {
                if (i < ops.length - 1) {
                    if (ops[i + 1].equals(C)) {
                        ops[i] = "0";
                        ops[i + 1] = "0";
                        i += 1;
                        continue;
                    }
                }
                sum += Integer.valueOf(current);
                firstNonZero = secondNonZero;
                secondNonZero = i;

            } else {
                if (current.equals(C)) { // 当前位置设置为0
                    // 当前位置设置为0
                    ops[i] = "0";
                    // 让first指向当前位置的前一个位置
                    // 设置second指向的数据为0
                    sum = sum - Integer.valueOf(ops[secondNonZero]);
                    ops[secondNonZero] = "0";
                    secondNonZero = firstNonZero;
                }
                if (current.equals(D)) { //当前位置设置为前一个数的两倍
                    firstNonZero = secondNonZero;
                    int newValue = 2 * Integer.valueOf(ops[firstNonZero]);
                    secondNonZero = i;
                    sum = sum + newValue;
                    ops[i] = "" + newValue;
                }
                if (current.equals(add)) { // 当前位置设置为前两个数的和
                    int newValue = Integer.valueOf(ops[firstNonZero]) + Integer.valueOf(ops[secondNonZero]);
                    sum = sum + newValue;
                    ops[i] = "" + newValue;
                    firstNonZero = secondNonZero;
                    secondNonZero = i;
                }
            }
        }
        return sum;
    }
}
