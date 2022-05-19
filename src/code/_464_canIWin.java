package code;

import tools.Asserts;

public class _464_canIWin extends Asserts {

    public static void main(String[] args) {
        _464_canIWin app = new _464_canIWin();

    }

    // 注意这个条件，假设两个选手表现都最佳
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 想输都难，先手的优势，当累计和小于池中的最大的数是，随便赢
        if (desiredTotal <= maxChoosableInteger){
            return true;
        }
        // 注意是两个人选的数同时作用在累计和上
        int iFirst = 0;
        int ySecond = 0;
        for (int i = maxChoosableInteger; i >= 1; i--) {
        }

        return false;
    }

}
