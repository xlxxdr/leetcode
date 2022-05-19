package studyPlan.binarySearch.phase1;


import java.util.Arrays;

import static tools.Asserts.*;

//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足：
//
//
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
//
//
//
//
// 示例 1：
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
//
//
// 示例 2：
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
//
//
// 示例 3：
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 500
// -10^3 <= arr[i] <= 10^3
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 53 👎 0
public class _1346_checkIfExist {

    public static void main(String[] args) {
        _1346_checkIfExist app = new _1346_checkIfExist();
        isTrue(app.checkIfExist(new int[]{-10, 12, -20, -8, 15}));
        isFalse(app.checkIfExist(new int[]{174,380,836,-114,211,-603,8,-787,920,363,-202,-394,32,23,-965,-334,253,785,-177,842,-424,-963,-679,-589,756,-329,661,153,602,-724,-306,-121,-564,-455,381,-803}));
        isFalse(app.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
        isFalse(app.checkIfExist(new int[]{-16, -13, 8}));
        isFalse(app.checkIfExist(new int[]{2, 3}));
        isTrue(app.checkIfExist(new int[]{10, 2, 5, 3}));
        isTrue(app.checkIfExist(new int[]{7, 1, 14, 11}));
        isFalse(app.checkIfExist(new int[]{3, 1, 7, 11}));

    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        String direction = "left";
        while (left != arr.length - 1) {
            int leftVal = arr[left];
            int rightVal = arr[right];
            double doubleLeftVal = leftVal < 0 ? (leftVal / 2.0) : (leftVal * 2.0);
            if (doubleLeftVal == rightVal) {
                return true;
            }
            if (doubleLeftVal > rightVal) {
                if (direction.equals("left")) {
                    if (right == arr.length - 1) {
                        // 说明当前left * 2比最后一个值还大，说明找不到 [2,2],虽然不存在
                        return false;
                    } else {
                        // 说明right进行过移动，说明没找到，
                        // 需要left向后一位，然后right向后一位（因为当前的left的两倍都不匹配，那么下一个的肯定还是小）
                        left++;
                        right++;
                        // 反转方向
                        direction = "right";
                    }

                } else if (direction.equals("right")) {
                    // 在向右边遍历的时候left * 2 < right的值，说明是left在移动
                    if (right == arr.length - 1) {
                        // 找到最后一个还不匹配，left++
                        // 反转方向
                        left++;
                        direction = "left";
                    } else {
                        right++;
                    }
                }
                // 左边的值的两倍大于右边的值，说明左边需要前进一位了，在进行比较
            }
            if (doubleLeftVal < rightVal) { // [1,2,3,4]
                if (direction.equals("left")) {
                    right--;
                    if (right == left) {
                        left++;
                        right+=2;
                        direction = "right";
                    }
                } else if (direction.equals("right")) {
                    if (right == arr.length -1 ){
                        // 向右边遍历到了最后一个元素，反转方向
                        left++;
                        direction = "left";
                    } else {
                        right++;
                    }
                }
            }
        }
        return false;
    }
}
