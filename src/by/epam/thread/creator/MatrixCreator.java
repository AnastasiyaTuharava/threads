package by.epam.thread.creator;

import by.epam.thread.entity.Matrix;

import java.util.Random;

public class MatrixCreator {
    public int [][] createMatrix() {
        Matrix.getMatrixInstance();
        int [][] squareMatrix = Matrix.getMatrixInstance().getSquareMatrix();
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                if (i == j) {
                    squareMatrix[i][j] = 0;
                } else {
                    squareMatrix[i][j] = new Random().nextInt(99);
                }
            }
        }
        return squareMatrix;
    }
}
