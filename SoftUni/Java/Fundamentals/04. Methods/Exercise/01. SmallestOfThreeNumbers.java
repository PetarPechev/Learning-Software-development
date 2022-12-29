package Exercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printSmallestNumOfThree(firstNum, secondNum, thirdNum);
    }

    private static void printSmallestNumOfThree(int firstNum, int secondNum, int thirdNum) {
        int smallestFromFirstTwo = Math.min(firstNum, secondNum);
        int smallestNum = Math.min(smallestFromFirstTwo, thirdNum);

        System.out.print(smallestNum);
    }

}
