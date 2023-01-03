package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputAsArray = input.split("\\s+");
            String command = inputAsArray[0];

            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(inputAsArray[1]);
                    containsElement(number, numbers);
                    break;
                case "Print":
                    String oddOrEven = inputAsArray[1];
                    printOddOrEvenNumbers(numbers, oddOrEven);
                    break;
                case "Get":
                    calculateSum(numbers);
                    break;
                case "Filter":
                    String sign = inputAsArray[1];
                    int numberToFiltrate = Integer.parseInt(inputAsArray[2]);
                    filtrateElements(numbers, sign, numberToFiltrate);
            }

            input = scanner.nextLine();
        }
    }

    private static void filtrateElements(List<Integer> numbers, String sign, int numberToFiltrate) {
        List<Integer> result = new ArrayList<>();

        switch (sign){
            case "<":
                result = numbers.stream().filter(e -> e < numberToFiltrate).collect(Collectors.toList());
                break;
            case ">":
                result = numbers.stream().filter(e -> e > numberToFiltrate).collect(Collectors.toList());
                break;
            case "<=":
                result = numbers.stream().filter(e -> e <= numberToFiltrate).collect(Collectors.toList());
                break;
            case ">=":
                result = numbers.stream().filter(e -> e >= numberToFiltrate).collect(Collectors.toList());
                break;
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void calculateSum(List<Integer> numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }

    private static void printOddOrEvenNumbers(List<Integer> numbers, String oddOrEven) {
        List<Integer> result = new ArrayList<>();

        if (oddOrEven.equals("even")) {
            result = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        } else {
            result = numbers.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void containsElement(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}
