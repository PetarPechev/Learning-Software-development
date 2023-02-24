package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillTheMatrix(size, scanner);
        System.out.print(calculateDiagonalDiff(matrix));
    }

    private static int calculateDiagonalDiff(int[][] matrix) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[matrix.length - 1 - i][i];
        }

        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }

    private static int[][] fillTheMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int column = 0; column < size; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
