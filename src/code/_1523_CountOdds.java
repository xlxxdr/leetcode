package code;


import tools.Asserts;


public class _1523_CountOdds {

    public static void main(String[] args) {
//        Asserts.equals(3, countOdds(3, 7));
//        Asserts.equals(1, countOdds(8, 10));
//        Asserts.equals(0, countOdds(8, 8));
//        Asserts.equals(1, countOdds(9, 9));
//        Asserts.equals(500000000, countOdds(0, 1000000000));

//        Asserts.equals(3, countOdds2(3, 7));
//        Asserts.equals(1, countOdds(8, 10));
//        Asserts.equals(0, countOdds2(8, 8));
//        Asserts.equals(1, countOdds2(9, 9));
//        Asserts.equals(500000000, countOdds2(0, 1000000000));

        Asserts.equals(2, countOdds3(14, 17));
        Asserts.equals(3, countOdds3(3, 7));
        Asserts.equals(1, countOdds3(8, 10));
        Asserts.equals(0, countOdds3(8, 8));
        Asserts.equals(1, countOdds3(9, 9));
        Asserts.equals(500000000, countOdds3(0, 1000000000));

    }

    public static int countOdds(int low, int high) {
        if (low < 0 || high < 0 || low > high) {
            return 0;
        }
        int oddsCount = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                oddsCount++;
            }
        }
        return oddsCount;
    }


    public static int countOdds2(int low, int high) {
        if (low < 0 || high < 0 || low > high) {
            return 0;
        }
        int oddsCount = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                // 找到的第一个奇数
                while (i <= high) {
                    i += 2;
                    oddsCount++;
                }
                break;
            }
        }
        return oddsCount;
    }

    public static int countOdds3(int low, int high) {
        if (low < 0 || high < 0 || low > high) {
            return 0;
        }
        // 如果高位是偶数，直接用公示
        // 如果高位是奇数，用high-low，不用算high这个数，放在外面加上
        return high % 2 == 0 ? (high - low + 1) >> 1 : ((high + 1 - low + 1) >> 1) ;
//        return (high - low + 1) % 2 == 0 ? (high - low + 1) >> 1 : ((high - low + 1) >> 1) + 1 ;
    }
}
