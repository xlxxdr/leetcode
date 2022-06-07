package studyPlan.programmingSkills.phase2;

import tools.Asserts;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
//
//
//
// 示例 1:
//
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 200
// num1 和 num2 只能由数字组成。
// num1 和 num2 都不包含任何前导零，除了数字0本身。
//
// Related Topics 数学 字符串 模拟 👍 948 👎 0
public class _43_multiply extends Asserts {

    public static void main(String[] args) {
        _43_multiply app = new _43_multiply();

    }


    /**
     * 问题分析，根据123 * 456 进行分析,
     *
     *         1  2  3
     *       x 4  5  6
     *  ----------------
     *   0  0  7  3  8
     * + 0  6  1  5  0
     * + 4  9  2  0  0
     * ----------------------
     *   5  6  0  8  8
     *
     *
     */
    public String multiply(String num1, String num2) {
        int s1Len = num1.length();
        int s2Len = num2.length();
        String lStr;
        String sStr;
        if (s1Len >= s2Len) {
            lStr = num1;
            sStr = num2;
        } else {
            lStr = num2;
            sStr = num1;
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < sStr.length(); k++) {
            int carry = 0;
            for (int i = 0; i < lStr.length(); i++) {
                int n1 = lStr.charAt(i) - 49;
                int n2 = sStr.charAt(k) - 49;
                carry = (n1 * n2) / 10 ;


            }
        }
        return "";

    }


}
