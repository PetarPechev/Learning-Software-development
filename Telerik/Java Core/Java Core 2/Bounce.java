package JavaCore2;

import java.util.Scanner;

/*Bounce
        Description
        You are given numbers N and M. They form a matrix of the powers of 2.

        Example: N = 3, M = 4

        1 2 4 8
        2 4 8 16
        4 8 16 32
        Starting from the top left corner of the matrix, Go with diagonal moves, until you hit a wall. When a wall is hit, change direction. You do this, until the direction cannot be changed, i.e. you hit a corner.
        Example:
        If you have the above matrix, the path will be: 1 4 16 16 4 4 4

        Your task is to find the sum of this path.

        Input
        Read from the standard input

        On the single line of the input, read the numbers N and M
        Output
        Print to the standard output

        On the single line of the output, print the sum of the path
        Sample tests
        Input
        3 4
        Output
        49*/

public class Bounce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        if (rows == 1 || columns == 1) {
            System.out.print(1);
            return;
        }

        System.out.print(getSumOfPath(rows, columns));
    }

    private static long getSumOfPath(int rows, int columns) {
        long result = 1;

        int row = 1;
        int col = 1;
        int directionRow = 1;
        int directionCol = 1;

        while (!isInTheCorner(row, col, rows, columns)) {
            result += getCurrentCellValue(row, col);

            int nextRow = row + directionRow;
            int nextCol = col + directionCol;

            if (isNotValid(nextRow, rows)) {
                directionRow *= -1;
            }
            if (isNotValid(nextCol, columns)) {
                directionCol *= -1;
            }

            row += directionRow;
            col += directionCol;
        }

        result += getCurrentCellValue(row, col);

        return result;
    }
    private static boolean isInTheCorner(int row, int col, int rows, int cols) {
        return (row == 0 && col == 0)
                || (row == 0 && col == cols - 1)
                || (row == rows - 1 && col == 0)
                || (row == rows - 1 && col == cols - 1);
    }
    private static long getCurrentCellValue(int row, int col) {
        int power = row + col;

        return (long) Math.pow(2, power);
    }
    private static boolean isNotValid(int nextPosition, int endPosition) {
        return nextPosition < 0 || nextPosition >= endPosition;
    }
}