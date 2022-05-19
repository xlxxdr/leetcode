package code.competition;

import tools.Asserts;

import java.util.*;
/*
给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。

返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1
输入：tasks = [2,2,3,3,2,4,4,4,4,4]
输出：4
解释：要想完成所有任务，一个可能的计划是：
- 第一轮，完成难度级别为 2 的 3 个任务。
- 第二轮，完成难度级别为 3 的 2 个任务。
- 第三轮，完成难度级别为 4 的 3 个任务。
- 第四轮，完成难度级别为 4 的 2 个任务。
可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。

输入：tasks = [2,3,3]
输出：-1
解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务
 */
public class _6071_minimumRounds {

    public static void main(String[] args) {
        _6071_minimumRounds app = new _6071_minimumRounds();
        Asserts.equals(4, app.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        Asserts.equals(-1, app.minimumRounds(new int[]{2, 3, 3}));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskMap = new HashMap<>();
        for (int task : tasks) {
            if (taskMap.containsKey(task)) {
                taskMap.put(task, taskMap.get(task) + 1);
            } else {
                taskMap.put(task, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : taskMap.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v < 2) {
                return -1;
            }
            int turn = v / 3 + (v % 3 == 0 ? 0 : 1);
            result += turn;
        }
        return result;
    }
}
