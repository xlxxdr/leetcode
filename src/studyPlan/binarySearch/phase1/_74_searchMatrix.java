package studyPlan.binarySearch.phase1;


import tools.Asserts;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10⁴ <= matrix[i][j], target <= 10⁴
//
// Related Topics 数组 二分查找 矩阵 👍 646 👎 0
public class _74_searchMatrix {

    public static void main(String[] args) {
        _74_searchMatrix app = new _74_searchMatrix();
        Asserts.isTrue(app.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        },3));

        Asserts.isFalse(app.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        },13));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] rNums : matrix) {
            int firstNum = rNums[0];
            int lastNum = rNums[rNums.length - 1];
            if (target >= firstNum || target <= lastNum){
                int left = 0;
                int right = rNums.length - 1;
                while (left <= right){
                    int mid = left + ((right - left) >> 1);
                    if (rNums[mid] == target) {
                        return true;
                    } else if (rNums[mid] > target){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                }
            }
        }
        return false;
    }
}
