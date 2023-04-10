package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;

        for (int numberFromArray = 0; numberFromArray < numbers.length; numberFromArray++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int leftNumber = 0; leftNumber < numberFromArray; leftNumber++) {
                leftSum+= numbers[leftNumber];
            }

            for (int rightNumber = numberFromArray + 1; rightNumber < numbers.length; rightNumber++) {
                rightSum += numbers[rightNumber];
            }

            if (leftSum == rightSum) {
                isEqual = true;
                System.out.print(numberFromArray);
            }
        }

        if (!isEqual){
            System.out.print("no");
        }
    }
}
