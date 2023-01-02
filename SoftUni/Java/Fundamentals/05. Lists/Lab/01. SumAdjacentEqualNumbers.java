package Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                double numberToAdd = numbers.get(i) + numbers.get(i + 1);
                numbers.set(i, numberToAdd);
                numbers.remove(i + 1);
                i = -1;
            }
        }

        printElementsByDelimiter(numbers);
    }

    public static void printElementsByDelimiter (List<Double> numbersList) {
        DecimalFormat df = new DecimalFormat("0.##");
        StringBuilder sb = new StringBuilder();

        for (Double number : numbersList) {
            sb.append(df.format(number) + " ");
        }

        System.out.print(sb);
    }
}
