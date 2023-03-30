import java.util.Scanner;

/*Knight Moves
        Description
        You are given a square board and a chess knight that can move on the board following the chess rules.

        You need to move the knight through the whole board following these additional rules:

        You start from the top left cell of the board
        At each turn, from all 8 possible moves, move the knight to the topmost, leftmost cell of the board that hasn't been visited
        If all the 8 positions have been already visited, restart moves from the leftmost, topmost unvisited cell
        At each turn leave a number on the cell, to indicate that the position has been visited and on which turn was visited
        By given the size of the board, print the board with the knight's moves on it.

        Input
        Read from the standard input

        On the single line of the input, find the number N
        The size of the board
        Output
        Print to the standard output

        On N lines, print N cells with the knight's moves on them
        Sample tests
        Input
        4
        Output
        1 4 7 10
        8 11 2 5
        3 6 9 12
        14 13 15 16
        Input
        5
        Output
        1 8 5 13 3
        6 14 2 9 12
        18 10 7 4 20
        15 22 19 11 17
        23 24 16 21 25
        Input
        3
        Output
        1 4 7
        6 9 2
        3 8 5*/


public class KnightMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int boardSize = Integer.parseInt(scanner.nextLine());
        int[][] boardWithKnightMoves = new int[boardSize][boardSize];

        getKnightMoves(boardWithKnightMoves);
        printBoardWithKnightMoves(boardWithKnightMoves);
    }

    private static void getKnightMoves(int[][] boardWithKnightMoves) {
        int tourCounter = 1;

        for (int r = 0; r < boardWithKnightMoves.length; r++) {
            for (int c = 0; c < boardWithKnightMoves[r].length; c++) {

                int row = r;
                int col = c;

                // path of horse
                while (boardWithKnightMoves[row][col] == 0) {
                    boardWithKnightMoves[row][col] = tourCounter;
                    tourCounter++;

                    int[] possibleRowMoves = { -2, -2, -1, -1, +1, +1, +2, +2 };
                    int[] possibleColMoves = { -1, +1, -2, +2, -2, +2, -1, +1 };

                    for (int dir = 0; dir < possibleRowMoves.length; dir++) {

                        int nextRow = row + possibleRowMoves[dir];
                        int nextCol = col + possibleColMoves[dir];

                        if (isNotValid(nextRow, nextCol, boardWithKnightMoves)) {
                            continue;
                        }

                        row = nextRow;
                        col = nextCol;
                        break;
                    }
                }
            }
        }
    }

    private static boolean isNotValid(int newRow, int newCol, int[][] boardWithKnightMoves) {

        return (newRow < 0 || newRow >= boardWithKnightMoves.length
                || newCol < 0 || newCol >= boardWithKnightMoves.length
                || boardWithKnightMoves[newRow][newCol] != 0);

    }

    private static void printBoardWithKnightMoves(int[][] boardWithKnightMoves) {
        for (int[] boardWithKnightMove : boardWithKnightMoves) {
            for (int col = 0; col < boardWithKnightMoves.length; col++) {
                System.out.print(boardWithKnightMove[col] + " ");
            }
            System.out.println();
        }
    }
}