package code.array;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import tools.Asserts;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * Related Topics
 * 数组
 * 哈希表
 * 排序
 */
public class _217_ContainsDuplicate extends Asserts {

    public static void main(String[] args) {
        _217_ContainsDuplicate app = new _217_ContainsDuplicate();
        isTrue(app.containsDuplicate(new int[]{1, 2, 3, 1}));
        isFalse(app.containsDuplicate(new int[]{1, 2, 3, 4}));
        isTrue(app.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }


    // 负数不适用
    public boolean containsDuplicate(int[] nums) {
        BigInteger num = new BigInteger("0");
        for (int i : nums) {
            if (num.testBit(i)){
                return true;
            }
            num = num.setBit(i);
        }
        return false;
    }




    public static boolean containsDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.putIfAbsent(num, num) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        return sets.size() == nums.length;
    }
}
