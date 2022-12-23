package Exercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfChars = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numOfChars; i++) {
            int currentChar = scanner.nextLine().charAt(0);
            sum += currentChar;
        }

        System.out.print("The sum equals: " + sum);
    }
}
