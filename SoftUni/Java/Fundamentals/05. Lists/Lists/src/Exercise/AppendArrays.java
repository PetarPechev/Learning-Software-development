package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|+")).collect(Collectors.toList());

        List<String> resultAsString = concatArraysAsString(input);

        List<Integer> resultAsIntegers = Arrays
                .stream(resultAsString.toString().replaceAll("[\\[\\],]", "").split("\\s+"))
                .map(Integer::parseInt).
                collect(Collectors.toList());

        System.out.print(resultAsIntegers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<String> concatArraysAsString(List<String> input) {
        List<String> resultAsString = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            String[] numbers = input.get(i).split("\\s+");

            for (int j = 0; j < numbers.length; j++) {
                if (!numbers[j].equals("")) {
                    resultAsString.add(numbers[j]);
                }
            }
        }

        return resultAsString;
    }
}
