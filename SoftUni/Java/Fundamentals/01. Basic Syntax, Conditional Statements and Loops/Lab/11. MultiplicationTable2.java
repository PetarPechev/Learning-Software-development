package Lab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = Integer.parseInt(scanner.nextLine());

        for (int i = startNumber; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number * i);
        }

        if (startNumber > 10) {
            System.out.printf("%d X %d = %d%n", number, startNumber, number * startNumber);
        }
    }
}
