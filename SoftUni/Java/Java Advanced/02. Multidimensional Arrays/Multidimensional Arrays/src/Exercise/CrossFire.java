package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = fillTheMatrix(rows, cols);

        String line = scanner.nextLine();

        while (!line.equals("Nuke it from orbit")){
            String[] data = line.split(" ");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            removeVerticalElements(matrix, row, col, radius);
            removeHorizontalElements(matrix, row, col, radius);
            matrix.removeIf(List::isEmpty);

            line = scanner.nextLine();
        }

        printTheMatrix(matrix);
    }

    private static void printTheMatrix(List<List<Integer>> matrix) {
        for(List<Integer> row : matrix){
            System.out.println(row.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static void removeHorizontalElements(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = col + radius; i >= col - radius; i--) {
            if (isInRange(row, i, matrix)){
                matrix.get(row).remove(i);
            }
        }
    }

    private static void removeVerticalElements(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isInRange(i, col, matrix) && i != row){
                matrix.get(i).remove(col);
            }
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> fillTheMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        return matrix;
    }
}