package Lab;

import java.util.Collections;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();

        while (!textInput.equals("end")) {
            System.out.println(textInput + " = " + reverseString(textInput));

            textInput = scanner.nextLine();
        }
    }

    private static String reverseString(String textInput) {
        StringBuilder sb = new StringBuilder();

        for (int i = textInput.length() - 1; i >= 0; i--) {
            sb.append(textInput.charAt(i));
        }

        return sb.toString();
    }
}
