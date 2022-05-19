package competitions._293;



import tools.Asserts;

import java.util.Arrays;

//Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
//
//给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
//
//返回不含特殊楼层的 最大 连续楼层数。
//输入：bottom = 2, top = 9, special = [4,6]
//输出：3
//解释：下面列出的是不含特殊楼层的连续楼层范围：
//- (2, 3) ，楼层数为 2 。
//- (5, 5) ，楼层数为 1 。
//- (7, 9) ，楼层数为 3 。
//因此，返回最大连续楼层数 3 。
public class _6064_maxConsecutive {

    public static void main(String[] args) {
        _6064_maxConsecutive app = new _6064_maxConsecutive();
        Asserts.equals(7, app.maxConsecutive(2, 9, new int[]{9}));
        Asserts.equals(3, app.maxConsecutive(2, 9, new int[]{4, 6}));
        Asserts.equals(0, app.maxConsecutive(6, 8, new int[]{6, 7, 8}));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        Arrays.sort(special);
        int occupyFloor = special[0];
        int sum = 0;
        int ofFlag = 1;
        for (int i = bottom; i <= top; i++) {
            if (i < occupyFloor) { //空闲楼层
                sum = occupyFloor - i;
                if (max <= sum) {
                    max = sum;
                }
                i = occupyFloor;
                // 设置到下一个
                if (ofFlag < special.length) {
                    occupyFloor = special[ofFlag++];
                }
                sum = 0;
            }
            if (i == occupyFloor) {//楼层相等
                if (max < sum) {
                    max = sum;
                }
                sum = 0;
                // 设置到下一个
                if (ofFlag < special.length) {
                    occupyFloor = special[ofFlag++];
                }
            }
            if (i > occupyFloor && occupyFloor == special[special.length - 1]) {
                sum = top - occupyFloor;
                if (max <= sum){
                    max = sum;
                    break;
                }
            }
        }
        return max;
    }
}
