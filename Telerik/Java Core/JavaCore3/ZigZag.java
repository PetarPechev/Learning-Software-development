package JavaCore3;

import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        System.out.print(getSumOfPath(rows, columns));
    }

    private static long getSumOfPath(int rows, int columns) {
        long sumOfPath = 1;
        int currentRow = 1;
        int currentCol = 1;
        int directionRow = 1;
        int directionCol = 1;

        while (currentRow < rows) {
            sumOfPath += (currentRow + currentCol) * 3 + 1;

            if (currentCol == 0 || currentCol == columns - 1) {
                directionCol *= -1;
                directionRow = 1;
            } else {
                directionRow *= -1;
            }

            currentRow += directionRow;
            currentCol += directionCol;
        }

        return sumOfPath;
    }
}