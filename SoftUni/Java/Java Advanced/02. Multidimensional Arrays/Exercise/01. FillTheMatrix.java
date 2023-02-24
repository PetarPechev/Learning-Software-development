package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        char method = input[1].charAt(0);
        int[][] matrix = new int[size][size];

        if (method == 'A') {
            fillMatrixMethodA(matrix);
        } else if (method == 'B') {
            fillMatrixMethodB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void fillMatrixMethodB(int[][] matrix) {
        int counter = 1;

        for (int col = 0; col < matrix.length; col++) {

            if ((col + 1) % 2 == 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillMatrixMethodA(int[][] matrix) {
        int counter = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }
}
