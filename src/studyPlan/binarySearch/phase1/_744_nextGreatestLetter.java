package studyPlan.binarySearch.phase1;

import tools.Asserts;

//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
//
// 在比较时，字母是依序循环出现的。举个例子：
//
//
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
//
//
//
//
// 示例 1：
//
//
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
//
//
// 示例 2:
//
//
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
//
//
// 示例 3:
//
//
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
//
//
//
//
// 提示：
//
//
// 2 <= letters.length <= 10⁴
// letters[i] 是一个小写字母
// letters 按非递减顺序排序
// letters 最少包含两个不同的字母
// target 是一个小写字母
//
// Related Topics 数组 二分查找 👍 221 👎 0
public class _744_nextGreatestLetter {

	public static void main(String[] args) {
		_744_nextGreatestLetter app = new _744_nextGreatestLetter();
		Asserts.equals('a', app.nextGreatestLetter(new char[] {'a', 'b', 'c'}, 'z'));
		Asserts.equals('c', app.nextGreatestLetter(new char[] {'c', 'f', 'g'}, 'a'));
		Asserts.equals('f', app.nextGreatestLetter(new char[] {'c', 'f', 'g'}, 'c'));
		Asserts.equals('f', app.nextGreatestLetter(new char[] {'c', 'f', 'g'}, 'd'));
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (letters[mid] > target) {
				right = mid;
			}
			if (letters[mid] <= target) {
				left = mid + 1;
			}

		}
		if (right + 1 == letters.length && letters[right] <= target) {
			return letters[0];
		}
		return letters[right];
	}

}
