package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            int[] input = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int commandType = input[0];

            if (commandType == 1) {
                numbers.push(input[1]);
            } else if (commandType == 2 && !numbers.isEmpty()) {
                numbers.pop();
            } else if (commandType == 3) {
                System.out.println(Collections.max(numbers));
            }
        }
    }
}
