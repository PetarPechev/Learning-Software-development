package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            System.out.print("NO");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (isOpenBracket(currentChar)) {
                openBrackets.push(currentChar);
            } else {
                char lastOpenBracket = openBrackets.pop();

                if (!isBalanced(lastOpenBracket, currentChar)) {
                    System.out.print("NO");
                    return;
                }
            }
        }

        System.out.print("YES");
    }

    private static boolean isOpenBracket(char currentChar) {
        return currentChar == '{' || currentChar == '(' || currentChar == '[';
    }

    private static boolean isBalanced(char lastOpenBracket, char currentChar) {
        return (lastOpenBracket == '{' && currentChar == '}')
                || (lastOpenBracket == '(' && currentChar == ')')
                || (lastOpenBracket == '[' && currentChar == ']');
    }
}
