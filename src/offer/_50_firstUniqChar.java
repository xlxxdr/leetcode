package offer;

import tools.Asserts;

import java.util.*;
import java.util.stream.Collectors;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
//示例 1:
//
//输入：s = "abaccdeff"
//输出：'b'
//示例 2:
//
//输入：s = "" 
//输出：' '
//
//
//限制：
//
//0 <= s 的长度 <= 50000
//
public class _50_firstUniqChar {

    public static void main(String[] args) {
        _50_firstUniqChar app = new _50_firstUniqChar();
        Asserts.equals('b', app.firstUniqChar("abaccdeff"));
        Asserts.equals(' ', app.firstUniqChar(""));

    }


    public char firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a'] = charCount[c - 'a'] + 1;
        }
        char ret = ' ';
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a'] == 1) {
                ret = c;
                break;
            }
        }
        return ret;
    }

    public char firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : chars) {
            Integer count = charCountMap.get(c);
            if (count == null) {
                charCountMap.put(c, 1);
            } else {
                charCountMap.put(c, count + 1);
            }
        }
        List<Character> list = charCountMap.keySet().stream()
                .filter(k -> charCountMap.get(k) == 1).collect(Collectors.toList());
        return list.isEmpty() ? ' ' : list.get(0);
    }

    public char firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        List<Character> oneChars = new LinkedList<>();
        List<Character> dupChars = new LinkedList<>();
        for (char c : chars) {
            if (dupChars.contains(c)) {
                continue;
            } else {
                if (oneChars.contains(c)) {
                    dupChars.add(c);
                    oneChars.remove((Character) c);
                } else {
                    oneChars.add(c);
                }
            }
        }
        return oneChars.isEmpty() ? ' ' : oneChars.get(0);
    }

}
