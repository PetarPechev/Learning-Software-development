package JavaCore3;

import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] spiralMatrix = new int[n][n];

        fillTheMatrix(spiralMatrix, n);
        printMatrix(spiralMatrix);
    }

    private static void fillTheMatrix(int[][] spiralMatrix, int n) {
        int counter = 1;
        int minCol = 0;
        int maxCol = n - 1;
        int minRow = 0;
        int maxRow = n - 1;

        while (counter <= n * n) {
            counter = getCounterAndFillOneRotation(spiralMatrix, counter, minCol, maxCol, minRow, maxRow);

            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
    }

    static int getCounterAndFillOneRotation(int[][] spiralMatrix, int counter, int minCol, int maxCol, int minRow, int maxRow) {
        for (int i = minCol; i <= maxCol; i++) {
            spiralMatrix[minRow][i] = counter;
            counter++;
        }

        for (int i = minRow + 1; i <= maxRow; i++) {
            spiralMatrix[i][maxCol] = counter;
            counter++;
        }

        for (int i = maxCol - 1; i >= minCol; i--) {
            spiralMatrix[maxRow][i] = counter;
            counter++;
        }

        for (int i = maxRow - 1; i >= minRow + 1; i--) {
            spiralMatrix[i][minCol] = counter;
            counter++;
        }

        return counter;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(row[col] + " ");
            }
            System.out.println();
        }
    }
}