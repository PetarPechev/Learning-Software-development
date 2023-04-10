package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixRowAndCols = scanner.nextLine();
        int rows = Integer.parseInt(matrixRowAndCols.split(", ")[0]);
        int columns = Integer.parseInt(matrixRowAndCols.split(", ")[1]);
        int sumOfElements = 0;

        for (int row = 0; row < rows; row++) {
            sumOfElements += Arrays
                    .stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .limit(columns)
                    .sum();
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sumOfElements);
    }
}
