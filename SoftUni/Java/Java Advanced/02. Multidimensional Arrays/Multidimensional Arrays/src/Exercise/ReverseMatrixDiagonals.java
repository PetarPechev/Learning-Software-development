package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = fillMatrix(rows, cols, scanner);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){
            int r = row;
            int c = col;

            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }

            System.out.println();
            col--;

            if(col == -1){
                col = 0;
                row--;
            }
        }
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}
