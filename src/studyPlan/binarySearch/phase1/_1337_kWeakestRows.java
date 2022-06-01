package studyPlan.binarySearch.phase1;

import tools.Asserts;

import java.util.LinkedHashSet;
import java.util.Set;

//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
//
//
//
// 示例 1：
//
//
//输入：mat =
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]],
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2
//行 1 -> 4
//行 2 -> 1
//行 3 -> 2
//行 4 -> 5
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
//
//
// 示例 2：
//
//
//输入：mat =
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]],
//k = 2
//输出：[0,2]
//解释：
//每行中的军人数目：
//行 0 -> 1
//行 1 -> 4
//行 2 -> 1
//行 3 -> 1
//从最弱到最强对这些行排序后得到 [0,2,3,1]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 2 <= n, m <= 100
// 1 <= k <= m
// matrix[i][j] 不是 0 就是 1
//
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 👍 164 👎 0
public class _1337_kWeakestRows extends Asserts {

    public static void main(String[] args) {
        _1337_kWeakestRows app = new _1337_kWeakestRows();

        equals(getIntArray(0), app.kWeakestRows(new int[][]{
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
        }, 1));

        equals(getIntArray(2, 0, 3), app.kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, 3));

        equals(getIntArray(0, 2), app.kWeakestRows(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {}
        }, 2));
        equals(getIntArray(0, 2, 3, 1), app.kWeakestRows(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {}
        }, 4));


    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        Set<Integer> set = new LinkedHashSet<>();
        Set<Integer> lastOne = new LinkedHashSet<>();
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 0) {
                    if (!set.contains(j)) {
                        set.add(j);
                    }
                }
                if (i == (mat[0].length - 1) && mat[j][i] == 1) {
                    if (!lastOne.contains(j)) {
                        lastOne.add(j);
                    }
                }
            }
        }
        set.addAll(lastOne);
        int flag = 0;
        for (Integer num : set) {
            result[flag++] = num;
            if (flag == k) {
                break;
            }
        }
        return result;
    }

}
