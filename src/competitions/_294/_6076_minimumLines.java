package competitions._294;

import tools.Asserts;

public class _6076_minimumLines extends Asserts {

    public static void main(String[] args) {
        _6076_minimumLines app = new _6076_minimumLines();
//        equals(1, app.minimumLines(new int[][]{
//                {3, 4}, {1, 2}, {7, 8}, {2, 3}
//        }));
//        equals(3, app.minimumLines(new int[][]{
//                {1, 7},
//                {2, 6},
//                {3, 5},
//                {4, 4},
//                {5, 4},
//                {6, 3},
//                {7, 2},
//                {8, 1}
//        }));
//        [[72,98],[62,27],[32,7],[71,4],[25,19],[91,30],[52,73],[10,9],[99,71],[47,22],[19,30],[80,63],[18,15],[48,17],[77,16],[46,27],[66,87],[55,84],[65,38],[30,9],[50,42],[100,60],[75,73],[98,53],[22,80],[41,61],[37,47],[95,8],[51,81],[78,79],[57,95]]
        equals(30, app.minimumLines(new int[][]{
                {72, 98}, {62, 27}, {32, 7}, {71, 4}, {25, 19}, {91, 30}, {52, 73}, {10, 9}, {99, 71}, {47, 22}, {19, 30}, {80, 63}, {18, 15}, {48, 17}, {77, 16}, {46, 27}, {66, 87}, {55, 84}, {65, 38}, {30, 9}, {50, 42}, {100, 60}, {75, 73}, {98, 53}, {22, 80}, {41, 61}, {37, 47}, {95, 8}, {51, 81}, {78, 79}, {57, 95}
        }));
    }

    public int minimumLines(int[][] stockPrices) {
        double rate = 0;
        int line = 0;
        for (int i = 0; i < stockPrices.length - 1; i++) {
            int[] point1 = stockPrices[i];
            int[] point2 = stockPrices[i + 1];
            int x1 = point1[0];
            int y1 = point1[1];
            int x2 = point2[0];
            int y2 = point2[1];
            // 斜率
            double k = ((y2 - y1) * 1.0) / (x2 - x1);
            System.out.println("k = " + k);
            if (k != rate) {
                line++;
                rate = k;
            }
        }
        return line;
    }

}
