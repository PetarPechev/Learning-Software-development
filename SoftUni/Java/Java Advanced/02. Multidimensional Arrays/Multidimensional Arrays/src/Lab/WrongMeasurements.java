package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] oldMatrix = new int[rows][];
        int[][] newMatrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            oldMatrix[i] = Arrays.stream(currentRow).toArray();
            newMatrix[i] = Arrays.stream(currentRow).toArray();
        }

        replaceWrongMeasurements(oldMatrix, newMatrix, scanner);

        for (int[] row : newMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void replaceWrongMeasurements(int[][] oldMatrix, int[][] newMatrix, Scanner scanner) {
        String wrongMeasureInput = scanner.nextLine();
        int wrongMeasureRow = Integer.parseInt(wrongMeasureInput.split("\\s+")[0]);
        int wrongMeasureCol = Integer.parseInt(wrongMeasureInput.split("\\s+")[1]);
        int wrongMeasureSize = oldMatrix[wrongMeasureRow][wrongMeasureCol];

        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                if (oldMatrix[row][col] == wrongMeasureSize) {
                    newMatrix[row][col] = sumNearestValidElements(oldMatrix, row, col, wrongMeasureSize);
                }
            }
        }
    }

    private static int sumNearestValidElements(int[][] oldMatrix, int row, int col, int wrongMeasureSize) {
        int sum = 0;

        if (row - 1 >= 0 && oldMatrix[row - 1][col] != wrongMeasureSize) {
            sum += oldMatrix[row - 1][col];
        }
        if (row + 1 < oldMatrix.length && oldMatrix[row + 1][col] != wrongMeasureSize) {
            sum += oldMatrix[row + 1][col];
        }
        if (col - 1 >= 0 && oldMatrix[row][col - 1] != wrongMeasureSize) {
            sum += oldMatrix[row][col - 1];
        }
        if (col + 1 < oldMatrix[row].length && oldMatrix[row][col + 1] != wrongMeasureSize) {
            sum += oldMatrix[row][col + 1];
        }

        return sum;
    }
}
