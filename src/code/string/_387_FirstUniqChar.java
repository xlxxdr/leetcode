package code.string;

import java.util.LinkedHashMap;

import code.tools.Asserts;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 * Related Topics
 * 队列
 * 哈希表
 * 字符串
 * 计数
 */
public class _387_FirstUniqChar {

	public static void main(String[] args) {
		_387_FirstUniqChar app = new _387_FirstUniqChar();
		Asserts.equals(0, app.firstUniqChar("leetcode"));
		Asserts.equals(2, app.firstUniqChar("loveleetcode"));
		Asserts.equals(-1, app.firstUniqChar("aabb"));
		Asserts.equals(-1, app.firstUniqChar("aadadaad"));
	}

	public int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				map.computeIfPresent(chars[i], (k, v) -> -1);
			} else {
				map.putIfAbsent(chars[i], i);
			}

		}
		if (map.isEmpty()) {
			return -1;
		} else {
			for (Character character : map.keySet()) {
				if (map.get(character) != -1){
					return map.get(character);
				}
			}
		}
		return -1;
	}

}
