package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = fillTheMatrix(rows, columns, scanner);
        char[][] secondMatrix = fillTheMatrix(rows, columns, scanner);
        char[][] intersectedMatrix = fillIntersectedMatrix(firstMatrix, secondMatrix);

        printMatrix(intersectedMatrix);
    }

    private static void printMatrix(char[][] intersectedMatrix) {
        for (char[] currentRow : intersectedMatrix) {
            System.out.println(Arrays.toString(currentRow).replaceAll("[\\[\\],]", ""));
        }
    }

    private static char[][] fillIntersectedMatrix(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] intersectedMatrix = new char[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                boolean areSame = firstMatrix[row][col] == secondMatrix[row][col];
                intersectedMatrix[row][col] = areSame ? firstMatrix[row][col] : '*';
            }
        }

        return intersectedMatrix;
    }

    private static char[][] fillTheMatrix(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
