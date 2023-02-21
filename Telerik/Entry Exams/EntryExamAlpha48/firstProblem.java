package EntryExamAlpha48;

import java.util.Scanner;

public class firstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int sum = 0;

        for (String currentSymbol : input) {
            if (currentSymbol.equals("d")) {
                sum = 0;
            } else {
                int currentNumber = Integer.parseInt(currentSymbol);
                sum += currentNumber;
            }
        }

        if (sum >= 0) {
            System.out.print("happy " + sum);
        } else {
            System.out.print("sad " + sum);
        }
    }
}
