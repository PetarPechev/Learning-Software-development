package Exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacters(text);
    }

    private static void printMiddleCharacters(String text) {
        int position = 0;
        int length = 0;

        if (text.length() % 2 == 0){
            position = text.length() / 2 - 1;
            length = 2;
        } else  {
            position = text.length() / 2;
            length = 1;
        }

        System.out.println(text.substring(position, position + length));
    }
}
