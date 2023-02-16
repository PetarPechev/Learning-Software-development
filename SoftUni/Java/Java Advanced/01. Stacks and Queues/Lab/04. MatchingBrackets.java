package Lab;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> openBracketIndexes = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            if (currentChar == '('){
                openBracketIndexes.push(index);
            } else if (currentChar == ')' && !openBracketIndexes.isEmpty()) {
                int startIndex = openBracketIndexes.pop();
                String contest = input.substring(startIndex, index + 1);
                System.out.println(contest);
            }
        }
    }
}
