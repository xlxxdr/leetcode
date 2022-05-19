package offer;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import tools.Asserts;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
//
//
//示例:
//
//现有矩阵 matrix 如下：
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//给定 target=5，返回true。
//
//给定target=20，返回false。
//
public class _04_findNumberIn2DArray extends Asserts {

    public static void main(String[] args) {
        _04_findNumberIn2DArray app = new _04_findNumberIn2DArray();
        isTrue(app.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
        isFalse(app.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));

    }

    // 解题思路：
    // 由于是每行是递增的，所以每行遇到大于target的下标就跳出这行，
    // 从下一行开始
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int col = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (matrix[i][k] == target) {
                    return true;
                } else if (matrix[i][k] > target) {
                    break;
                }
            }
        }
        return false;
    }
}
