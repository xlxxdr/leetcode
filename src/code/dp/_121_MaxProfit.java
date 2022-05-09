package code.dp;

import code.tools.Asserts;

/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
提示：

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class _121_MaxProfit {

    public static void main(String[] args) {
        _121_MaxProfit app = new _121_MaxProfit();
        Asserts.equals(5,app.maxProfit(new int[]{7,1,5,3,6,4}));
        Asserts.equals(0,app.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        /*
         记录【今天之前买入的最小值】
         计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
         比较【每天的最大获利】，取最大值即可
         */
        int max = 0,min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
