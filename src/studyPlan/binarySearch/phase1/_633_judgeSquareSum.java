package studyPlan.binarySearch.phase1;

import static tools.Asserts.*;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
//
//
//
// 示例 1：
//
//
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
//
//
// 示例 2：
//
//
//输入：c = 3
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= c <= 2³¹ - 1
//
// Related Topics 数学 双指针 二分查找 👍 354 👎 0
public class _633_judgeSquareSum {

    public static void main(String[] args) {
        _633_judgeSquareSum app = new _633_judgeSquareSum();
        isTrue(app.judgeSquareSum(0));
        isTrue(app.judgeSquareSum(2));
        isFalse(app.judgeSquareSum(2147483647));
        isTrue(app.judgeSquareSum(1000));
        isFalse(app.judgeSquareSum(3));
        isTrue(app.judgeSquareSum(5));
        isTrue(app.judgeSquareSum(1));
    }

    public boolean judgeSquareSum(int c) {
        //46340 最大整数平方根
        int left = 0;
        int right = 46340;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int midSquare = mid * mid;
            if (midSquare < c) {
                left = mid + 1;
            } else if (midSquare == c) {
                return true;
            } else if (midSquare > c) {
                right = mid - 1;
            }
        }
        int begin = 0;
        int end = left  + 1;
        while (begin != end) {
            int beginSquare = begin * begin;
            int endSquare = end * end;
            if (beginSquare + beginSquare == c || endSquare + endSquare == c){
                return true;
            }
            if ((beginSquare  + endSquare) > c || (beginSquare + endSquare < 0)){
                end--;
            } else if (beginSquare + endSquare == c){
                return true;
            } else if ((beginSquare + endSquare) < c){
                begin++;
            }
        }
        return false;
    }



    public boolean judgeSquareSum_timeout2(int c) {
        //46340 最大整数平方根
        int left = 0;
        int right = 46340;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int midSquare = mid * mid;
            if (midSquare < c) {
                left = mid + 1;
            } else if (midSquare == c) {
                return true;
            } else if (midSquare > c) {
                right = mid - 1;
            }
        }
        int begin = left;
        for (int i = 0; i <= begin; i++) {
            int i2 = i * i;
            if (i2 > c) {
                return false;
            } else if (i2 == c) {
                return true;
            }
            for (int k = 0; k <= begin; k++) {
                int k2 = k * k;
                if (k2 > c) {
                    break;
                } else if (k2 == c) {
                    break;
                }
                int num = i2 + k2;
                if (num == c) {
                    return true;
                } else if (num > c) {
                    break;
                } else if (num < 0) {
                    continue;
                }
            }
        }
        return false;
    }
    public boolean judgeSquareSum_timeout(int c) {
        //46340 最大整数平方根
        for (int i = 0; i <= 46340; i++) {
            int i2 = i * i;
            if (i2 > c) {
                return false;
            } else if (i2 == c) {
                return true;
            }
            for (int k = 0; k <= 46340; k++) {
                int k2 = k * k;
                if (k2 > c) {
                    break;
                } else if (k2 == c) {
                    break;
                }
                int num = i2 + k2;
                if (num == c) {
                    return true;
                } else if (num > c) {
                    break;
                } else if (num < 0) {
                    continue;
                }
            }
        }
        return false;
    }

}
