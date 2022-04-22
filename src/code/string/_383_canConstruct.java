package code.string;

import java.util.Map;
import java.util.TreeMap;

import code.tools.Asserts;
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 308 👎 0

public class _383_canConstruct {

	public static void main(String[] args) {
		_383_canConstruct app = new _383_canConstruct();
		Asserts.equalsFalse(app.canConstruct("a","b"));
		Asserts.equalsFalse(app.canConstruct("aa","ab"));
		Asserts.equalsTrue(app.canConstruct("aa","aa"));
		Asserts.equalsTrue(app.canConstruct("aa","aab"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		char[] c1 = ransomNote.toCharArray();
		char[] c2 = magazine.toCharArray();
		Map<Character, Integer> c1Map = new TreeMap<>();
		Map<Character, Integer> c2Map = new TreeMap<>();
		for (int i = 0; i < c1.length; i++) {

			Integer c1Val = c1Map.putIfAbsent(c1[i], 1);
			if (c1Val != null) {
				c1Map.computeIfPresent(c1[i], (k, v) -> v + 1);
			}
			Integer c2Val = c2Map.putIfAbsent(c2[i], 1);
			if (c2Val != null) {
				c2Map.computeIfPresent(c2[i], (k, v) -> v + 1);
			}

		}
		for (Character key : c1Map.keySet()) {
			if (!c2Map.containsKey(key)){
				return false;
			}
			if (c1Map.get(key) > c2Map.get(key)){
				return false;
			}
		}
		return true;
	}
}
