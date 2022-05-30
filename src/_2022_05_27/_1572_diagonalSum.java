package _2022_05_27;

import tools.Asserts;
//给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
//
// 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
//
//
//
// 示例 1：
//
//
//
//
//输入：mat = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//输出：25
//解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
//请注意，元素 mat[1][1] = 5 只会被计算一次。
//
//
// 示例 2：
//
//
//输入：mat = [[1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1]]
//输出：8
//
//
// 示例 3：
//
//
//输入：mat = [[5]]
//输出：5
//
//
//
//
// 提示：
//
//
// n == mat.length == mat[i].length
// 1 <= n <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics 数组 矩阵 👍 51 👎 0

public class _1572_diagonalSum extends Asserts {

	public static void main(String[] args) {
		_1572_diagonalSum app = new _1572_diagonalSum();
		equals(55, app.diagonalSum(getInt2DArrayFromString("[[7,3,1,9],[3,4,6,9],[6,9,6,6],[9,5,8,5]]")));
		equals(25, app.diagonalSum(getInt2DArrayFromString("[[1,2,3],[4,5,6],[7,8,9]]")));
		equals(8, app.diagonalSum(getInt2DArrayFromString("[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]")));
		equals(5, app.diagonalSum(getInt2DArrayFromString("[[5]]")));
	}

	public int diagonalSum(int[][] mat) {
			// 暴力法，要区分数组长度的奇偶性
			// 长度偶数：不需要减去中间元素
			// 长度奇数：需要减去中间元素
			int sum = 0;
			int len = mat.length;
			for (int i = 0; i < len; i++) {
				sum += mat[i][i];
				sum += mat[i][len - 1 - i];
			}
			if (len % 2 != 0) {
				sum -= mat[len >> 1][len >> 1];
			}
			return sum;
	}

}
