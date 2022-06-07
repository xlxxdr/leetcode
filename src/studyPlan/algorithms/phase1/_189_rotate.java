package studyPlan.algorithms.phase1;

import sun.plugin.cache.CacheUpdateHelper;
import tools.Asserts;

import java.util.Arrays;

//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -2³¹ <= nums[i] <= 2³¹ - 1
// 0 <= k <= 10⁵
//
//
//
//
// 进阶：
//
//
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//
//
//
//
//
//
//
// Related Topics 数组 数学 双指针 👍 1496 👎 0

public class _189_rotate extends Asserts {

    public static void main(String[] args) {
        _189_rotate app = new _189_rotate();
        int[] array = getIntArray(1, 2, 3, 4, 5, 6, 7);
        app.rotate(array, 3);
        equals(Arrays.toString(getIntArray("[5,6,7,1,2,3,4]")), Arrays.toString(array));
        array = getIntArray(1, 2, 3, 4, 5, 6, 7);
        app.rotate(array, 1);
        equals(Arrays.toString(getIntArray("[7, 1, 2, 3, 4, 5, 6]")), Arrays.toString(array));

        array = getIntArray("[1,2,3,4,5,6]");
        app.rotate(array, 2);
        equals(Arrays.toString(getIntArray("[5,6,1,2,3,4]")), Arrays.toString(array));


        array = getIntArray("[1,2,3,4,5,6]");
        app.rotate(array, 6);
        equals(Arrays.toString(getIntArray("[1,2,3,4,5,6]")), Arrays.toString(array));

        array = getIntArray("[1,2,3,4,5,6]");
        app.rotate(array, 1);
        equals(Arrays.toString(getIntArray("[6,1,2,3,4,5]")), Arrays.toString(array));


        array = getIntArray("[1,2,3,4]");
        app.rotate(array, 2);
        equals(Arrays.toString(getIntArray("[3,4,1,2]")), Arrays.toString(array));

        array = getIntArray("[-1,-100,3,99,6,5,9]");
        app.rotate(array, 2);
        equals(Arrays.toString(getIntArray("[5,9,-1,-100,3,99,6]")), Arrays.toString(array));


        array = getIntArray("[-1]");
        app.rotate(array, 2);
        equals(Arrays.toString(getIntArray("[-1]")), Arrays.toString(array));


        array = getIntArray("[1,2,3,4,5,6,7]");
        app.rotate(array, 3);
        equals(Arrays.toString(getIntArray("[5,6,7,1,2,3,4]")), Arrays.toString(array));

        array = getIntArray("[1,2]");
        app.rotate(array, 3);
        equals(Arrays.toString(getIntArray("[2,1]")), Arrays.toString(array));


        //[28,2,3,4,5,6,7,8,9,37,11,12,13,14,15,16,17,18,1,20,21,22,23,24,25,26,27,1,29,30,31,32,33,34,35,36,10,38,39,40,41,42,43,44,45]
        array = getIntArray("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25" +
                ",26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45]");
        app.rotate(array, 36);
        equals(Arrays.toString(getIntArray("[10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29," +
                "30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,1,2,3,4,5,6,7,8,9]")), Arrays.toString(array));


    }

    public void rotate(int[] nums, int k) {
        // 根据数学计算下标
        // 假设原下标为 i --> 旋转后的下标为 (i + k) % len
        if (k % nums.length == 0) {
            return;
        } else {
            k = k % nums.length;
        }
        int count = 0;
        int currentPos = 0;
        int currentVal = nums[currentPos];
        int turnBegin = 0;
        while (count != nums.length) {
            // 如果是在绕圈，当回到一个圈的原点时，进入到下一个节点
            int pos = (currentPos + k) % nums.length;
            if (pos == turnBegin) {
                turnBegin++;
                nums[pos] = currentVal;
                int tmp = nums[turnBegin];
                currentVal = tmp;
                count++;
                currentPos = turnBegin;
            } else {
                int tmp = nums[pos];
                nums[pos] = currentVal;
                currentVal = tmp;
                currentPos = pos;
                count++;
            }
        }
    }
}
