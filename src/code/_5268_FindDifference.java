package code;

import java.util.ArrayList;
import java.util.List;

/*
给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：

    answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
    answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。

注意：列表中的整数可以按 任意 顺序返回。
输入：nums1 = [1,2,3], nums2 = [2,4,6]
输出：[[1,3],[4,6]]
解释：
对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
 */
class _5268_FindDifference {

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{-3,6,-5,4,5,5}, new int[]{6,6,-3,-3,3,5}));
        System.out.println(findDifference(new int[]{-80,-15,-81,-28,-61,63,14,-45,-35,-10}, new int[]{-1,-40,-44,41,10,-43,69,10,2}));
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        List<Integer> rN1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int flag = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    nums2[j] = 1001;
                    rN1.add(nums1[i]);
                } else {
                    flag++;
                }
            }
            if (flag == nums2.length){
                if (!n1.contains(nums1[i]) && !rN1.contains(nums1[i])){
                    n1.add(nums1[i]);
                }
            }
        }
        for (int i : nums2) {
            if (i != 1001){
                if (!n2.contains(i)){
                    n2.add(i);
                }

            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(n1);
        result.add(n2);
        return result;
    }
}