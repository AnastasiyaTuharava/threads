package by.epam.thread.entity;

public class Matrix {
    private static Matrix matrixInstance;
    private int[][] squareMatrix;
    private Matrix() {
        final int SIZE = 10;
        squareMatrix = new int[SIZE][SIZE];
    }
    public static Matrix getMatrixInstance() {
        if (matrixInstance == null) {
            matrixInstance = new Matrix();
        }
            return matrixInstance;
    }

    public int[][] getSquareMatrix() {
        return squareMatrix;
    }

    public void setSquareMatrix(int[][] squareMatrix) {
        this.squareMatrix = squareMatrix;
    }

    public int getElement (int i, int j) {
        return squareMatrix[i][j];
    }

    public void changeElement (int i, int k) {
        squareMatrix[i][i] = k;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for (int[] squareMatrix1 : squareMatrix) {
            for (int i : squareMatrix1) {
                sb.append(String.format("%6d", i));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
