package code.array;

import java.util.Arrays;

//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
//
// 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -
//1 。
//
//
// 示例 1：
//
//
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
//
//
// 示例 2：
//
//
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
//
//
// 示例 3：
//
//
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
//
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 2 * 10⁴
// intervals[i].length == 2
// -10⁶ <= starti <= endi <= 10⁶
// 每个间隔的起点都 不相同
//
// Related Topics 数组 二分查找 排序 👍 164 👎 0
public class _436_findRightInterval {

    public static void main(String[] args) {
        _436_findRightInterval app = new _436_findRightInterval();
        int[] ints = app.findRightInterval(new int[][]{
                {1, 2}
        });
        System.out.println(Arrays.toString(ints));
        ints = app.findRightInterval(new int[][]{
                {3, 4}, {2, 3}, {1, 2}
        });
        System.out.println(Arrays.toString(ints));
        ints = app.findRightInterval(new int[][]{
                {1, 4}, {2, 3}, {3, 4}
        });
        System.out.println(Arrays.toString(ints));

        ints = app.findRightInterval(new int[][]{
                {4, 5}, {2, 3}, {1, 2}
        });
        System.out.println(Arrays.toString(ints));

        //[3,3,3,4,5,-1]
        ints = app.findRightInterval(new int[][]{
                {1, 12}, {2, 9}, {3, 10}, {13, 14}, {15, 16}, {16, 17}
        });
        System.out.println(Arrays.toString(ints));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int rightVal = interval[1];
            // 取出每一个右边的元素
            // 通过二分查找在所有的左元素中查找，如果找到，返回index
            // 如果没找到，就返回-1
            boolean found = false;
            int equals = -1;
            int bigger = -1;
            int minBigNum = Integer.MAX_VALUE;
            for (int k = 0; k < intervals.length; k++) {
                int leftVal = intervals[k][0];
                if (leftVal == rightVal) {
                    found = true;
                    equals = k;
                }
                if (leftVal > rightVal) {
                    found = true;
                    if (leftVal < minBigNum){
                        minBigNum = leftVal;
                        bigger = k;
                    }
                }
            }
            if (!found) {
                result[i] = -1;
            } else {
                if (equals != -1) {
                    result[i] = equals;
                } else if (bigger != -1) {
                    result[i] = bigger;
                }
            }
        }
        return result;
    }
}
