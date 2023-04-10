package Lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = fillTheBoard(scanner);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessboard[row][col] == 'q') {
                    if (checkForRealQueen(chessboard, row, col))
                    System.out.printf("%d %d", row, col);
                    break;
                }
            }
        }
    }

    private static boolean checkForRealQueen(char[][] chessboard, int row, int col) {
        return checkHorizontalMove(chessboard, row, col) && checkVerticalMove(chessboard, row, col)
                && checkFirstDiagonalMove(chessboard, row, col) && checkSecondDiagonalMove(chessboard, row, col);
    }

    private static boolean checkSecondDiagonalMove(char[][] chessboard, int row, int col) {
        int columnIndex = col - 1;

        for (int rowIndex = row + 1; rowIndex < 8 && columnIndex >= 0; rowIndex++, columnIndex--) {
            if (chessboard[rowIndex][columnIndex] == 'q') {
                return false;
            }
        }

        columnIndex = col + 1;

        for (int rowIndex = row - 1; rowIndex >= 0 && columnIndex < 8; rowIndex--, columnIndex++) {
            if (chessboard[rowIndex][columnIndex] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checkFirstDiagonalMove(char[][] chessboard, int row, int col) {
        int columnIndex = col - 1;
        for (int rowIndex = row - 1; rowIndex >= 0 && columnIndex >= 0; rowIndex--, columnIndex--) {
            if (chessboard[rowIndex][columnIndex] == 'q') {
                return false;
            }
        }

        columnIndex = col + 1;

        for (int rowIndex = row + 1; rowIndex < 8 && columnIndex < 8; rowIndex++, columnIndex++) {
            if (chessboard[rowIndex][columnIndex] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checkVerticalMove(char[][] chessboard, int row, int col) {
        for (int indexRow = 0; indexRow < 8; indexRow++) {
            if (indexRow == row) {
                continue;
            }

            if (chessboard[indexRow][col] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static boolean checkHorizontalMove(char[][] chessboard, int row, int col) {
        for (int index = 0; index < 8; index++) {
            if (index == col) {
                continue;
            }

            if (chessboard[row][index] == 'q') {
                return false;
            }
        }

        return true;
    }

    private static char[][] fillTheBoard(Scanner scanner) {
        char[][] board = new char[8][8];

        for (int row = 0; row < 8; row++) {
            char[] currentRow = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

            for (int col = 0; col < 8; col++) {
                board[row][col] = currentRow[col];
            }
        }

        return board;
    }
}
