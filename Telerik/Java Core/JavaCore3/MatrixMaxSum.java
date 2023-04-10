package JavaCore3;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        fillTheMatrix(matrix, rows, scanner);

        int[] rcPairs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(getMaxSum(matrix, rcPairs));
    }

    private static void fillTheMatrix(int[][] matrix, int rows, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            int[] currentArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentArray;
        }
    }
    private static int getMaxSum(int[][] matrix, int[] rcPairs) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rcPairs.length; i += 2) {
            int row = rcPairs[i];
            int col = rcPairs[i + 1];
            int startRow = Math.abs(row) - 1;
            int startCol = Math.abs(col) - 1;

            int currentSum = returnSumFromRowMovement(row, startRow, startCol, matrix)
                    + returnSumFromColMovement(col, startRow, startCol, matrix);

            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
    private static int returnSumFromRowMovement(int row, int startRow, int startCol, int[][] matrix) {
        int sumFromRowMovement = 0;

        if (row > 0) {
            for (int col = 0; col < startCol; col++) {
                sumFromRowMovement += matrix[startRow][col];
            }
        } else {
            for (int col = matrix[startRow].length - 1; col > startCol; col--) {
                sumFromRowMovement += matrix[startRow][col];
            }
        }

        return sumFromRowMovement;
    }
    private static int returnSumFromColMovement(int col, int startRow, int startCol, int[][] matrix) {
        int sumFromColMovement = 0;

        if (col > 0) {
            for (int row = startRow; row >= 0; row--) {
                sumFromColMovement += matrix[row][startCol];
            }
        } else {
            for (int row = startRow; row < matrix.length; row++) {
                sumFromColMovement += matrix[row][startCol];
            }
        }

        return sumFromColMovement;
    }
}