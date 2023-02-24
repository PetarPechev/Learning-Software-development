package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int column = 0; column < matrixSize; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        printFirstDiagonal(matrix);
        printSecondDiagonal(matrix);
    }

    private static void printSecondDiagonal(int[][] matrix) {
        for (int index = 0; index < matrix.length; index++) {
            System.out.print(matrix[matrix.length - 1 - index][index] + " ");
        }
        System.out.println();
    }

    private static void printFirstDiagonal(int[][] matrix) {
        for (int index = 0; index < matrix.length; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
    }
}
