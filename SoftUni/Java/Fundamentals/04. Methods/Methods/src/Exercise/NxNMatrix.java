package Exercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printMatrix(size);
    }

    private static void printMatrix(int size) {

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print(size + " ");
            }

            System.out.println();
        }
    }
}
