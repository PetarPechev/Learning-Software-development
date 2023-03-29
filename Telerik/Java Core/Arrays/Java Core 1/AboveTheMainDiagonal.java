import java.util.Scanner;

/*Above the Main Diagonal
        Description
        You are given a number N. Using it, create a square matrix of numbers, formed by powers of 2 and find the sum of the numbers above the main diagonal, excluding the diagonal itself.

        Input
        Read from the standard input.

        On the first line, read the number N - the number of rows and columns.
        Output
        Print to the standard output.

        On a single line print the sum of the numbers above the main diagonal excluding the diagonal.
        Constraints
        N can get as big as 30.
        Sample tests
        Input
        4
        Output
        70
        Explanation
        With N equal to 4, we will have a matrix that looks like this:

        1  2  4  8
        2  4  8 16
        4  8 16 32
        8 16 32 64
        The main diagonal is 1 4 16 64, so the sum of the numbers above it: 2 + 4 + 8 + 8 + 16 + 32 = 70.*/
public class AboveTheMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        long[][] matrix = fillTheMatrix(sizeOfMatrix);

        long sum = getSumOfMainDiagonal(matrix);

        System.out.print(sum);


        // Can be used also this where it was calculated only the sum:
       /* public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            long sum = 0;

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    if (j >= i){
                        sum += (long) Math.pow(2, i + j);
                    }
                }
            }

            System.out.println(sum);

        }*/

    }

    private static long getSumOfMainDiagonal(long[][] matrix) {
        long sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix.length; col++) {
                sum += matrix[row][col];
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
