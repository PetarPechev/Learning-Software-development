package Exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printTopNumbers(number);
    }

    private static void printTopNumbers(int number) {
        for (int num = 8; num <= number; num++) {

            int sumOfDigits = 0;
            boolean isOdd = false;
            int currentNum = num;

            while (currentNum > 0) {
                int currentDigit = currentNum % 10;
                currentNum /= 10;

                sumOfDigits+= currentDigit;

                if (currentDigit % 2 != 0){
                    isOdd = true;
                }
            }

            boolean isTopNumber = isOdd && sumOfDigits % 8 == 0;

            if (isTopNumber) {
                System.out.println(num);
            }
        }
    }
}
