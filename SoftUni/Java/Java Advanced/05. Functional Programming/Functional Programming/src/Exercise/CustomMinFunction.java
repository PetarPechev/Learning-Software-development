package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> minNumber = nums -> {
            int minValue = Integer.MAX_VALUE;

            for (Integer number : numbers) {
                if (minValue > number) {
                    minValue = number;
                }
            }

            return minValue;
        };

        int min = minNumber.apply(numbers);
        System.out.println(min);
    }
}
