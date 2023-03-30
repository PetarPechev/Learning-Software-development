package JavaCore2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*Navigation
        Description
        You are given a rectangular board. The board is filled with numbers that are power of 2, as follows:
        The bottom left corner holds the value 1
        The next cell above holds value of 2, the next cell above holds of 4, etc…
        The second cell the bottom row holds a value of 2, the cell next to it holds a value of 4
        You have a pawn on the field. The pawn can only move to the cells that directly above, below it or right/left of it. We have four directions UP, DOWN, LEFT, RIGHT.
        Given that initially the pawn starts in the bottom left corner and a list of cells that the pawn must reach calculate the sum of the cells that the pawn has to go through.
        The value of each cell is calculated only once, i.e. if the pawn visits the same cell more than once, its value is added to the result only the first time (the value is collected).
        The top row is at position 0, the bottommost row is at position ROWS – 1.
        The pawn goes from one cell to the other, following the rules:
        First go to the target column (move horizontally)
        Second go to the target row (move vertically)
        Example:
        The pawn collects values: 1, 2, 4, 8, 16, 32, 16, 8, 4, 8, 16, 32, 64, 128, 256 and 512. Their sum is 1107.

        Input
        The input data is given at the standard input, i.e. the console
        On the first and the second lines you will find the dimensions of the field R and C
        On the third line you will find the number N, the number of moves
        On the fourth line you will find the CODEs, decimal numbers that represents the positions from the path of the pawn. They will be separated by a single space. The position is encoded as follows:

        A coefficient is calculated, COEFF = MAX(R, C)
        ROW = CODE / COEF
        COL = CODE % COEF

        The input will be valid, in the specified format, within the constraints given below. There is no need to check the input data explicitly.

        Output
        Print the sum of cells contained in the path of pawn

        Constraints
        R will always be between 1 and 100
        C will always be between 1 and 75
        N will always be between 1 and 1000

        Sample Input
        Input
        5
        6
        4
        14 27 1 5
        Output
        1107*/

public class Navigation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        int moves = Integer.parseInt(scanner.nextLine());

        int[] positions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        BigInteger[][] matrix = fillTheMatrix(rows, columns);

        System.out.print(getSumOfPath(rows, columns, positions, matrix, moves));
    }

    private static BigInteger[][] fillTheMatrix(int rows, int columns) {
        BigInteger[][] matrix = new BigInteger[rows][columns];
        BigInteger counterRow = new BigInteger("1");

        for (int row = rows - 1; row >= 0; row--) {
            BigInteger counterCol = counterRow;

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = counterCol;
                counterCol = counterCol.multiply(BigInteger.valueOf(2));
            }

            counterRow = counterRow.multiply(BigInteger.valueOf(2));
        }

        return matrix;
    }
    private static BigInteger getSumOfPath(int rows, int columns, int[] positions, BigInteger[][] matrix, int moves) {
        BigInteger sumOfPath = new BigInteger("0");

        int startingRow = rows - 1;
        int startingCol = 0;
        int coefficient = Math.max(rows, columns);

        for (int move = 0; move < moves; move++) {
            int row = positions[move] / coefficient;
            int col = positions[move] % coefficient;

            sumOfPath = addColumnsSum(matrix, sumOfPath, startingRow, startingCol, col);
            startingCol = col;

            sumOfPath = addRowsSum(matrix, sumOfPath, startingCol, startingRow, row);
            startingRow = row;
        }

        return sumOfPath;
    }
    private static BigInteger addColumnsSum(BigInteger[][] matrix, BigInteger sumOfPath, int startingRow, int startingCol, int col) {
        int minCol = Math.min(startingCol, col);
        int maxCol = Math.max(startingCol, col);

        for (int c = minCol; c <= maxCol; c++) {
            sumOfPath = sumOfPath.add(matrix[startingRow][c]);
            matrix[startingRow][c] = BigInteger.valueOf(0);
        }

        return sumOfPath;
    }
    private static BigInteger addRowsSum(BigInteger[][] matrix, BigInteger sumOfPath, int startingCol, int startingRow, int row) {
        int minRow = Math.min(startingRow, row);
        int maxRow = Math.max(startingRow, row);

        for (int r = minRow; r <= maxRow; r++) {
            sumOfPath = sumOfPath.add(matrix[r][startingCol]);
            matrix[r][startingCol] = BigInteger.valueOf(0);
        }

        return sumOfPath;
    }
}