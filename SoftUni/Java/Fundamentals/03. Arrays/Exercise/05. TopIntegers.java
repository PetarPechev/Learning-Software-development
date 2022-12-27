package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbersArray.length; i++) {
            boolean isBigger = true;

            for (int j = i + 1; j < numbersArray.length; j++) {
                if (numbersArray[i] <= numbersArray[j]) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger){
                System.out.print(numbersArray[i] + " ");
            }
        }
    }
}
