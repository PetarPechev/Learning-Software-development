package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int halfOfListSize = numbers.size() / 2;

        for (int i = 0; i < halfOfListSize; i++) {
            int numToAdd = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i, numToAdd);
            numbers.remove(numbers.size() - 1);
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
