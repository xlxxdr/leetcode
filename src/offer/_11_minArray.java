package offer;

import tools.Asserts;

import java.util.Arrays;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
//给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
//
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//
//
//
//示例 1：
//
//输入：numbers = [3,4,5,1,2]
//输出：1
//示例 2：
//
//输入：numbers = [2,2,2,0,1]
//输出：0

public class _11_minArray {

    public static void main(String[] args) {
        _11_minArray app = new _11_minArray();
        Asserts.equals(1, app.minArray(Asserts.getIntArray(1,2,3)));
        Asserts.equals(1, app.minArray(Asserts.getIntArray(3, 4, 5, 1, 2)));
        Asserts.equals(0, app.minArray(Asserts.getIntArray(2, 2, 2, 0, 1)));

    }

    public int minArray1(int[] numbers) {
        if (numbers.length == 1){
            return numbers[0];
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            } else {
                // 自然升序
                if (i == numbers.length - 2){
                    return numbers[0];
                }
            }
        }
        return -1;
    }


    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
