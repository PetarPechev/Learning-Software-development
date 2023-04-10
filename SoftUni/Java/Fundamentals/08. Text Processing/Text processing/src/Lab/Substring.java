package Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToRemove = scanner.nextLine();
        String text = scanner.nextLine();

        System.out.println(textWithRemovedString(stringToRemove, text));
    }

    private static String textWithRemovedString(String stringToRemove, String text) {
        while (text.contains(stringToRemove)) {
            text = text.replace(stringToRemove, "");
        }

        return text;
    }
}
