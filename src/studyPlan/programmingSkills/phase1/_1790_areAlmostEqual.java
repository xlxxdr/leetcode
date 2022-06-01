package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//
//
// 示例 2：
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
//
//
// 示例 3：
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
//
//
// 示例 4：
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 和 s2 仅由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 31 👎 0


public class _1790_areAlmostEqual extends Asserts {

    public static void main(String[] args) {
        _1790_areAlmostEqual app = new _1790_areAlmostEqual();
//        "siyolsdcjthwsiplccjbuceoxmpjgrauocx"
//        "siyolsdcjthwsiplccpbuceoxmjjgrauocx"
//        isTrue(app.areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx", "siyolsdcjthwsiplccpbuceoxmjjgrauocx"));
//        "akrjnhuojtkhlqdfifwxbsmphhcchuqcconcvplcyxjpi"
//        "akrjnhuojtkhlxdfifwqbsmphhcchuqcconcvplcyxjpi"
        isTrue(app.areAlmostEqual("akrjnhuojtkhlqdfifwxbsmphhcchuqcconcvplcyxjpi", "akrjnhuojtkhlxdfifwqbsmphhcchuqcconcvplcyxjpi"));
        isTrue(app.areAlmostEqual("a", "a"));
        isFalse(app.areAlmostEqual("a", "b"));
        isFalse(app.areAlmostEqual("abcd", "dcba"));
        isTrue(app.areAlmostEqual("bank", "kanb"));
        isFalse(app.areAlmostEqual("attack", "defend"));
        isTrue(app.areAlmostEqual("kelb", "kelb"));
    }


    public boolean areAlmostEqual(String s1, String s2) {
        if (!s1.equals(s2)) {
            if (s1.length() == 1 || s1.length() != s2.length()) {
                return false;
            }
            int diff1Pos = -1;
            int diff2Pos = -1;
            int left = 0;
            int right = s1.length() - 1;
            int diffCount = 0;
            while (left < right) {
                if (s1.charAt(left) != s2.charAt(left)) {
                    diffCount++;
                    if (diff1Pos == -1) {
                        diff1Pos = left;
                    }
                }
                left++;

                if (diff2Pos == -1) {
                    if (s1.charAt(right) != s2.charAt(right)) {
                        diff2Pos = right;
                        diffCount++;
                    } else {
                        right--;
                    }
                }
                if (diffCount > 2) {
                    return false;
                }
            }
            if (diffCount != 2) {
                return false;
            }
            if (s1.charAt(diff2Pos) == s2.charAt(diff1Pos) && s1.charAt(diff1Pos) == s2.charAt(diff2Pos)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean areAlmostEqual2(String s1, String s2) {
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
