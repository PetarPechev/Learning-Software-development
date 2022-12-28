package Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int reps = Integer.parseInt(scanner.nextLine());

        StringBuilder result = repeatString(text, reps);

        System.out.print(result);
    }

    private static StringBuilder repeatString(String text, int reps) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reps; i++) {
            result.append(text);
        }

        return result;
    }
}
