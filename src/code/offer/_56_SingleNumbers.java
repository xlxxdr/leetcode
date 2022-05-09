package code.offer;


import java.util.HashMap;
import java.util.Map;

/*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
限制：

2 <= nums.length <= 10000
Related Topics
位运算
数组
 */
public class _56_SingleNumbers {

    public static void main(String[] args) {
        _56_SingleNumbers app = new _56_SingleNumbers();

    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) != 0) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }
        int[] ret = new int[2];

        int i = 0;
        for (Integer n : map.keySet()) {
            ret[i] = n;
            i++;
        }
        return ret;
    }
}
