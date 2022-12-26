package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfStrings = scanner.nextLine().split("\\s+");

        for (int i = 0; i < arrayOfStrings.length / 2; i++) {
            String currentString = arrayOfStrings[i];
            arrayOfStrings[i] = arrayOfStrings[arrayOfStrings.length - i - 1];
            arrayOfStrings[arrayOfStrings.length - i - 1] = currentString;
        }

        for (String arrayOfString : arrayOfStrings) {
            System.out.print(arrayOfString + " ");
        }
    }
}
