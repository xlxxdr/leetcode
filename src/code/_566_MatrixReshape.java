package code;

public class _566_MatrixReshape {

    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if ((row * col) != (r * c)){
            // 不能刚好装下
            return mat;
        }
        int[][] newMatrix = new int[r][c];
//        row.for
        return newMatrix;
    }
}
