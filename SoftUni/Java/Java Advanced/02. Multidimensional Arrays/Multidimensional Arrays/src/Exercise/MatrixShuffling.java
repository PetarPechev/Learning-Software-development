package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split("\\s+")[0]);
        int cols = Integer.parseInt(rowsAndCols.split("\\s+")[1]);
        String[][] matrix = fillTheMatrix(rows, cols, scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];

            if (!command.equals("swap") || inputArr.length != 5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            int firsRow = Integer.parseInt(inputArr[1]);
            int firsCol = Integer.parseInt(inputArr[2]);
            int secondRow = Integer.parseInt(inputArr[3]);
            int secondCol = Integer.parseInt(inputArr[4]);

            if (checkAreValidIndexes(firsRow, firsCol, secondRow, secondCol, matrix)) {
                matrixShuffling(matrix, firsRow, firsCol, secondRow, secondCol);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static void matrixShuffling(String[][] matrix, int firsRow, int firsCol, int secondRow, int secondCol) {
        String oldElement = matrix[firsRow][firsCol];
        matrix[firsRow][firsCol] = matrix[secondRow][secondCol];
        matrix[secondRow][secondCol] = oldElement;
    }

    private static void printMatrix(String[][] biggestMatrix) {
        for (String[] row : biggestMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean checkAreValidIndexes(int firsRow, int firsCol, int secondRow, int secondCol, String[][] matrix) {
        return (firsRow >= 0 && firsRow < matrix.length)
                && (firsCol >= 0 && firsCol <= matrix[0].length)
                && (secondRow >= 0 && secondRow < matrix.length)
                && (secondCol >= 0 && secondCol < matrix[0].length);
    }

    private static String[][] fillTheMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++) {
                matrix[row][column] = currentRow[column];
            }
        }

        return matrix;
    }
}
