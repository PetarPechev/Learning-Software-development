package JavaCore1;

import java.util.Scanner;

/*Above the Main Diagonal 2
        Description
        You are given a number N. Using it, create a square matrix of numbers, formed by powers of 2 and find the sum of the numbers above the main diagonal, including the diagonal itself.

        Input
        Read from the standard input.

        On the first line, read the number N - the number of rows and columns.
        Output
        Print to the standard output.

        On a single line print the sum of the numbers above the main diagonal including the diagonal.
        Constraints
        N can get as big as 30.
        Sample tests
        Input
        4
        Output
        155
        Explanation
        With N equal to 4, we will have a matrix that looks like this:

        1  2  4  8
        2  4  8 16
        4  8 16 32
        8 16 32 64
        The main diagonal is 1 4 16 64, so its sum, plus the sum of the numbers above it is: 1 + 2 + 4 + 8 + 4 + 8 + 16 + 16 + 32 + 64 = 155.*/
public class AboveTheMainDiagonal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        long[][] matrix = fillTheMatrix(sizeOfMatrix);

        long sum = getSumOfMainDiagonal(matrix);

        System.out.print(sum);

        // Can be used also this also:
      /*  public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            long[][] matrix = new long[n][n];
            matrix[0][0] = 1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0){
                    matrix[i][0] = matrix[i - 1][0] * 2;
                }
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = matrix[i][j - 1] * 2;
                    if (j > i) {
                        sum += matrix[i][j];
                    }
                }
            }
            System.out.println(sum);
        }*/

    }

    private static long getSumOfMainDiagonal(long[][] matrix) {
        long sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix.length; col++) {
                if (col >= row) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    private static long[][] fillTheMatrix(int sizeOfMatrix) {
        long[][] matrix = new long[sizeOfMatrix][sizeOfMatrix];
        long counter = 1;

        for (int row = 0; row < sizeOfMatrix; row++) {
            for (int col = 0; col < sizeOfMatrix; col++) {
                matrix[row][col] = counter;
                counter = 2 * counter;
            }

            counter = 2 * matrix[row][0];
        }

        return matrix;
    }
}
