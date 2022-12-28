package Lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        printTriangle(size);
    }

    private static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printNumsOfTriangle(i);
        }

        for (int i = size - 1; i >= 1; i--) {
            printNumsOfTriangle(i);
        }
    }

    public static void printNumsOfTriangle (int length) {
        for (int j = 1; j <= length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
