package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int angleOfRotation = Integer.parseInt(command.split("[\\(\\)]")[1]) % 360;
        int maxLength = Integer.MIN_VALUE;

        String input = scanner.nextLine();
        List<String> stringList = new ArrayList<>();

        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            stringList.add(input);
            input = scanner.nextLine();
        }

        addEmptySpace(stringList, maxLength);

        int row = stringList.size();
        int col = maxLength;
        char[][] matrix = new char[row][col];

        fillTheMatrix(matrix, stringList, row, col);
        printRotatedMatrix(matrix, row, col, angleOfRotation);
    }

    private static void printRotatedMatrix(char[][] matrix, int row, int col, int angleOfRotation) {
        switch (angleOfRotation) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                printOn90Degrees(matrix, row, col);
                break;
            case 180:
                printOn180Degrees(matrix, row, col);
                break;
            case 270:
                printOn270Degrees(matrix, row, col);
                break;
        }
    }

    private static void fillTheMatrix(char[][] matrix, List<String> stringList, int row, int col) {
        for (int r = 0; r < row; r++) {
            matrix[r] = stringList.get(r).toCharArray();
        }
    }
    private static void printOn270Degrees(char[][] matrix, int row, int col) {
        for (int c = col - 1; c >= 0; c--) {
            for (int r = 0; r < row; r++) {
                System.out.print(matrix[r][c]);
            }

            System.out.println();
        }
    }

    private static void printOn180Degrees(char[][] matrix, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                System.out.print(matrix[r][c]);
            }

            System.out.println();
        }
    }

    private static void printOn90Degrees(char[][] matrix, int row, int col) {
        for (int c = 0; c < col; c++) {
            for (int r = row - 1; r >= 0; r--) {
                System.out.print(matrix[r][c]);
            }

            System.out.println();
        }
    }

    private static void addEmptySpace(List<String> stringList, int maxLength) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).length() < maxLength) {
                int difference = maxLength - stringList.get(i).length();
                String current = stringList.get(i);
                stringList.set(i, current + (" ".repeat(difference)));
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] x : matrix) {
            for (char y : x) {
                System.out.print(y);
            }

            System.out.println();
        }
    }
}
