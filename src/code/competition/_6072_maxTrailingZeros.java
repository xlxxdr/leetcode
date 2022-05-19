package code.competition;

import tools.Asserts;

/*
转角路径的乘积中最多能有几个尾随零

给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。

转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；反之亦然。当然，同样不能访问之前已经访问过的单元格。

一条路径的 乘积 定义为：路径上所有值的乘积。

请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。

注意：

    水平 移动是指向左或右移动。
    竖直 移动是指向上或下移动。
输入：grid = [[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]
输出：3
解释：左侧的图展示了一条有效的转角路径。
其乘积为 15 * 20 * 6 * 1 * 10 = 18000 ，共计 3 个尾随零。
可以证明在这条转角路径的乘积中尾随零数目最多。

中间的图不是一条有效的转角路径，因为它有不止一个弯。
右侧的图也不是一条有效的转角路径，因为它需要重复访问已经访问过的单元格。
 */
public class _6072_maxTrailingZeros {

    public static void main(String[] args) {
        _6072_maxTrailingZeros app = new _6072_maxTrailingZeros();
        Asserts.equals(3, app.maxTrailingZeros(new int[][]{
                {23, 17, 15, 3, 20},
                {8, 1, 20, 27, 11},
                {9, 4, 6, 2, 21},
                {40, 9, 1, 10, 6},
                {22, 7, 4, 5, 3},
        }));
    }

    public int maxTrailingZeros(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = -1;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                // 1.找到第一个五的倍数的数字，
                if (grid[i][k] % 5 == 0) {
                    // 2.横向，纵向查找 r1
                    int r1 = rowTrailingZeros(i, k, grid);
                    // 3.纵向，横向查找 r2
                    int r2 = colTrailingZeros(i, grid);
                    // tmpMax = Max(r1,r2)
                    int tmpMax = Math.max(r1, r2);
                    // max = = Max(max,tmpMax)
                    max = Math.max(max, tmpMax);
                }
            }
        }
        return max;
    }

    public int rowTrailingZeros(int row, int col, int[][] grid) {
        int zeros = 1;
        int colLen = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            if (i == col){
                continue;
            }
            for (int k = 0; k < colLen; k++) {
                if (grid[i][k] % 5 == 0) {
                    zeros++;
                }
            }

        }
        System.out.println(zeros);
        return zeros;
    }

    public int colTrailingZeros(int coli, int[][] grid) {
        return -1;
    }
}
