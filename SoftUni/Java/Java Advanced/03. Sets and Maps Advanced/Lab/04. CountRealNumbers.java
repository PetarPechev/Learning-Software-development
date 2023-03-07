package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersWithOccurrence = new LinkedHashMap<>();

        for (double number : numbers) {
            numbersWithOccurrence.putIfAbsent(number, 0);
            numbersWithOccurrence.put(number, numbersWithOccurrence.get(number) + 1);
        }

        numbersWithOccurrence.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
