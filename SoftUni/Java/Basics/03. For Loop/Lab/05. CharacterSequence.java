package Lab;

import java.util.Scanner;

public class CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int index = 0; index < input.length(); index++) {
            System.out.println(input.charAt(index));
        }
    }
}
