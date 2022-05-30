package _2022_05_27;

import tools.Asserts;

//给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥
//有的 资产总量 。
//
// 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
//
//
//
// 示例 1：
//
// 输入：accounts = [[1,2,3],[3,2,1]]
//输出：6
//解释：
//第 1 位客户的资产总量 = 1 + 2 + 3 = 6
//第 2 位客户的资产总量 = 3 + 2 + 1 = 6
//两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
//
//
// 示例 2：
//
// 输入：accounts = [[1,5],[7,3],[3,5]]
//输出：10
//解释：
//第 1 位客户的资产总量 = 6
//第 2 位客户的资产总量 = 10
//第 3 位客户的资产总量 = 8
//第 2 位客户是最富有的，资产总量是 10
//
// 示例 3：
//
// 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
//输出：17
//
//
//
//
// 提示：
//
//
// m == accounts.length
// n == accounts[i].length
// 1 <= m, n <= 50
// 1 <= accounts[i][j] <= 100
//
// Related Topics 数组 矩阵 👍 110 👎 0
public class _1672_maximumWealth extends Asserts {

	public static void main(String[] args) {
		_1672_maximumWealth app = new _1672_maximumWealth();
	equals(6,app.maximumWealth(getInt2DArrayFromString("[[1,2,3],[3,2,1]]")));
	equals(17,app.maximumWealth(getInt2DArrayFromString("[[2,8,7],[7,1,3],[1,9,5]]")));
	}

	public int maximumWealth(int[][] accounts) {
		// 暴力出奇迹
		int sum = Integer.MIN_VALUE;
		for (int[] account : accounts) {
			int personSum = 0;
			for (int money : account) {
				personSum += money;
			}
			if (personSum > sum) {
				sum = personSum;
			}
		}
		return sum;
	}

}
