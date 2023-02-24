package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixRowsAndCols = scanner.nextLine();
        int rowsMatrix = Integer.parseInt(matrixRowsAndCols.split(", ")[0]);
        int colsMatrix = Integer.parseInt(matrixRowsAndCols.split(", ")[1]);
        int[][] matrix = fillTheMatrix(rowsMatrix, colsMatrix, scanner);
        int[][] biggestSubMatrix = new int[2][2];
        int biggestSum = 0;

        for (int row = 0; row < rowsMatrix - 1; row++) {
            for (int col = 0; col < colsMatrix - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    biggestSubMatrix = fillBiggestSubMatrix(row, col, matrix);
                }
            }
        }

        for (int[] row : biggestSubMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }

        System.out.println(biggestSum);
    }

    private static int[][] fillBiggestSubMatrix(int row, int col, int[][] matrix) {
        int[][] subMatrix = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                subMatrix[i][j] = matrix[row + i][col + j];
            }
        }

        return subMatrix;
    }

    private static int[][] fillTheMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
