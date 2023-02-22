package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstMatrixRowsAndCols = scanner.nextLine();
        int rowFirstMatrix = Integer.parseInt(firstMatrixRowsAndCols.split("\\s+")[0]);
        int colFirstMatrix = Integer.parseInt(firstMatrixRowsAndCols.split("\\s+")[1]);
        int[][] firstMatrix = fillTheMatrix(rowFirstMatrix, colFirstMatrix, scanner);
        String secondMatrixRowsAndCols = scanner.nextLine();
        int rowSecondMatrix = Integer.parseInt(secondMatrixRowsAndCols.split("\\s+")[0]);
        int colSecondMatrix = Integer.parseInt(secondMatrixRowsAndCols.split("\\s+")[1]);
        int[][] secondMatrix = fillTheMatrix(rowSecondMatrix, colSecondMatrix, scanner);

        if (rowFirstMatrix != rowSecondMatrix || colFirstMatrix != colSecondMatrix) {
            System.out.print("not equal");
        } else {
            compareMatrices(firstMatrix, secondMatrix);
        }
    }

    private static void compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areSame = true;

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.print("not equal");
                    areSame = false;
                    break;
                }
            }
            if (!areSame){
                break;
            }
        }

        if (areSame) {
            System.out.println("equal");
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
