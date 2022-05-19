package studyPlan.binarySearch.phase2;

import tools.Asserts;

import java.util.*;

//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足：
//
//
// |a - x| < |b - x| 或者
// |a - x| == |b - x| 且 a < b
//
//
//
//
// 示例 1：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 10⁴
// arr 按 升序 排列
// -10⁴ <= arr[i], x <= 10⁴
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 322 👎 0
public class _658_findClosestElements extends Asserts {

    public static void main(String[] args) {
        _658_findClosestElements app = new _658_findClosestElements();
//        [0,1,1,1,2,3,6,7,8,9]
//        9
//        4
        System.out.println(app.findClosestElements(getIntArray(0,1,1,1,2,3,6,7,8,9), 9, 4));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 4, 4, 5), 5, 6));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 4, 4, 5), 5, -1));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 4, 4, 5), 4, 4));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 3, 4, 5), 4, 6));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 3, 4, 5), 4, 3));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 3, 4, 5), 4, -1));
        System.out.println(app.findClosestElements(getIntArray(1, 2, 2, 2, 5), 2, 2));

    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        int pos = searchInsert(arr, x);
        if (pos == 0) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
        } else if (pos == arr.length) {
            pos--;
            for (int i = 0; i < k; i++) {
                result.add(arr[pos--]);
            }
        } else {
            int left = pos - 1 ;
            int right = pos;
            while (k != 0) {
                if (left ==  -1) {
                    for (int i = right; i < right + k; i++) {
                        result.add(arr[i]);
                    }
                    break;
                }
                if (right == arr.length) {
                    for (int i = 0 ; i < k; i++) {
                        result.add(arr[left--]);
                    }
                    break;
                }
                int leftVal = Math.abs(arr[left] - x);
                int rightVal = Math.abs(arr[right] - x);
                // 注意left 位置为0
                if (leftVal < rightVal) {
                    k--;
                    result.add(arr[left]);
                    left--;
                } else if (leftVal == rightVal) {
                    if (arr[left] < arr[right]) {
                        result.add(arr[left]);
                        k--;
                        left--;
                    } else {
                        result.add(arr[right]);
                        k--;
                        right++;
                    }
                } else {
                    // 注意right位置为arr.length - 1
                    // leftVal < rightVal
                    result.add(arr[right]);
                    right++;
                    k--;

                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midNum = nums[mid];
            if (midNum == target) {
                right = mid - 1;
            } else if (midNum > target) {
                right = mid - 1;
            } else if (midNum < target) {
                left = mid + 1;
            }
        }
        return right + 1;
    }

}
