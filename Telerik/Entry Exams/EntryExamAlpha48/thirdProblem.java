package EntryExamAlpha48;

import java.util.Scanner;

public class thirdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int biggestSum = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                String pair = input[i] + input[j];
                String reversePair = new StringBuilder(pair).reverse().toString();

                if (pair.equals(reversePair) && biggestSum < pair.length()) {
                    biggestSum = pair.length();
                }
            }
        }

        System.out.print(biggestSum);
    }
}
