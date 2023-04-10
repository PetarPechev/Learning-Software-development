package Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split("\\s+")[0]);
        int cols = Integer.parseInt(rowsAndCols.split("\\s+")[1]);

        for (int row = 0; row < rows; row++) {
            char leftAndRightChar = (char)('a' + row);

            for (int col = 0; col < cols; col++) {
                char middleChar = (char)(leftAndRightChar + col);

                System.out.printf("%c%c%c ", leftAndRightChar, middleChar, leftAndRightChar);
            }
            System.out.println();
        }
    }
}
