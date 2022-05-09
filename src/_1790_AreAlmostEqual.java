import code.tools.Asserts;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * 示例 1：
 *
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 *
 */
public class _1790_AreAlmostEqual {


    public static void main(String[] args) {
        Asserts.equalsTrue(areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx","siyolsdcjthwsiplccpbuceoxmjjgrauocx"));
        Asserts.equalsTrue(areAlmostEqual("bank","kanb"));
        Asserts.equalsFalse(areAlmostEqual("attack","defend"));
        Asserts.equalsTrue(areAlmostEqual("kelb","kelb"));
        Asserts.equalsFalse(areAlmostEqual("abcd","dcba"));

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length() || !s1.equals(s1)){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        int left = 0;
        int right = s2.length() - 1;

        boolean first = false;
        boolean second = false;
        while ( first == false  || second == false){
            if (!first){
                if (s1.charAt(left) == s2.charAt(left)){
                    left++;
                } else {
                    first = true;
                    System.out.println("first " + s2.charAt(left));
                }
            }
            if (!second){
                if (s1.charAt(right) == s2.charAt(right)){
                    right--;
                } else {
                    second = true;
                    System.out.println("second " +  s2.charAt(right));
                }
            }
        }

        char[] chars = s2.toCharArray();
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        return s1.equals(new String(chars));
    }
}
