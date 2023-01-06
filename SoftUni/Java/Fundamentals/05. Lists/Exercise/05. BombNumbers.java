package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombNumber = scanner.nextInt();
        int power = scanner.nextInt();

        while (numbers.contains(bombNumber)) {
            int bombNumberIndex = numbers.indexOf(bombNumber);
            int leftIndex = Math.max(0, bombNumberIndex - power);
            int rightIndex = Math.min(numbers.size() - 1, bombNumberIndex + power);

            numbers.subList(leftIndex, rightIndex + 1).clear();
        }

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.print(sum);
    }
}