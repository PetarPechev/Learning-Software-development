package MockExam4;

import java.util.Scanner;

public class MilitaryTanks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        int x = 0;
        int y = 0;

        for (int i = 0; i < input.length; i++) {
            char currentChar = input[i];

            switch (currentChar) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'U':
                    y++;
                    break;
            }
        }

        System.out.printf("(%d, %d)", x, y);
    }
}
