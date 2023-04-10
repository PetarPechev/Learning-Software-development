package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixRowsAndCols = scanner.nextLine();
        int rowsMatrix = Integer.parseInt(matrixRowsAndCols.split("\\s+")[0]);
        int colsMatrix = Integer.parseInt(matrixRowsAndCols.split("\\s+")[1]);
        int[][] matrix = fillTheMatrix(rowsMatrix, colsMatrix, scanner);
        int targetNum = Integer.parseInt(scanner.nextLine());

        positionOfTargetNum(matrix, targetNum);
    }

    private static void positionOfTargetNum(int[][] matrix, int targetNum) {
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == targetNum) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.print("not found");
        }
    }

    private static int[][] fillTheMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
