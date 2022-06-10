package studyPlan.programmingSkills.phase2;

import java.util.ArrayList;
import java.util.List;

import tools.Asserts;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 1118 👎 0

public class _54_spiralOrder extends Asserts {

	public static void main(String[] args) {
		_54_spiralOrder app = new _54_spiralOrder();
	}

    public List<Integer> spiralOrder(int[][] matrix) {
        int upperLeft = 0;
        int lowerLeft = matrix.length;
        int upperRight = matrix[0].length;
        int lowerRight = 0;
        return new ArrayList<>();
    }
}
