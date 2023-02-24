package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split("\\s+")[0]);
        int cols = Integer.parseInt(rowsAndCols.split("\\s+")[1]);
        int[][] matrix = fillTheMatrix(rows, cols, scanner);
        int biggestSum = 0;
        int[][] biggestMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = calculateCurrentSum(matrix, row, col);

                if (currentSum > biggestSum){
                    biggestSum = currentSum;
                    fillBiggestMatrix(matrix, row, col, biggestMatrix);
                }
            }
        }

        System.out.println("Sum = " + biggestSum);
        printBiggestMatrix(biggestMatrix);
    }

    private static void printBiggestMatrix(int[][] biggestMatrix) {
        for (int[] row : biggestMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void fillBiggestMatrix(int[][] matrix, int row, int col, int[][] biggestMatrix) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                biggestMatrix[r][c] = matrix[r + row][c + col];
            }
        }
    }

    private static int calculateCurrentSum(int[][] matrix, int row, int col) {
        int currentSum = 0;

        for (int r = row; r <= row + 2; r++) {
            for (int c = col; c <= col + 2; c++) {
                currentSum += matrix[r][c];
            }
        }

        return currentSum;
    }

    private static int[][] fillTheMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int column = 0; column < cols; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
