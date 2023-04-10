package Lab;

import java.util.Collections;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputAsArr = scanner.nextLine().split("\\s+");
        StringBuilder repeatedStrings = new StringBuilder();

        for (int i = 0; i < inputAsArr.length; i++) {
            String currentString = inputAsArr[i];

            repeatedStrings.append(Collections.nCopies(currentString.length(), currentString)
                    .toString().replaceAll("[\\[\\], ]", ""));

            //repeatStrings(repeatedStrings, currentString);

        }

        System.out.print(repeatedStrings);
    }

//    private static void repeatStrings(StringBuilder repeatedStrings, String currentString) {
//        for (int i = 0; i < currentString.length(); i++) {
//            repeatedStrings.append(currentString);
//        }
//    }
}
