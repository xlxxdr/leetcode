package code.binarysearch;

//猜数字游戏的规则如下：
//
//
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
//
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
//
//
// -1：我选出的数字比你猜的数字小 pick < num
// 1：我选出的数字比你猜的数字大 pick > num
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
//
//
// 返回我选出的数字。
//
//
//
// 示例 1：
//
//
//输入：n = 10, pick = 6
//输出：6
//
//
// 示例 2：
//
//
//输入：n = 1, pick = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：n = 2, pick = 1
//输出：1
//
//
// 示例 4：
//
//
//输入：n = 2, pick = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
// 1 <= pick <= n
//
// Related Topics 二分查找 交互 👍 210 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Forward declaration of guess API.
 * @  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class _374_guessNumber {

	public static void main(String[] args) {
		_374_guessNumber app = new _374_guessNumber();
		System.out.println(app.guessNumber(10));
	}

	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		int mid = low + (high - low) / 2;
		while (guess(mid) != 0) {
			if (guess(mid) == -1) {
				high = mid - 1;
			} else if (guess(mid) == 1) {
				low = mid + 1;
			}
			mid = low + (high - low) / 2;
		}
		return mid;
	}

	int guess(int num) {
		if (num == 6) {
			return 0;
		} else if (num > 6) {
			return 1;
		} else {
			return -1;
		}
	}
}
