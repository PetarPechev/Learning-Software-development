package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split("\\s+")[0];
            boolean isValidIndex = indexValidation(command, input, numbers.size() - 1);

            if (!isValidIndex) {
                System.out.println("Invalid index");
                input = scanner.nextLine();
                continue;
            }

            if (command.equals("Add")) {
                numbers = addNumber(numbers, input);
            } else if (command.equals("Insert")) {
                numbers = insertNumber(numbers, input);
            } else if (command.equals("Remove")) {
                numbers = removeAtIndex(numbers, input);
            } else if (command.equals("Shift")) {
                numbers = shiftNumber(numbers, input);
            }

            input = scanner.nextLine();
        }

        printNumbers(numbers);
    }

    private static boolean indexValidation(String command, String input, int numbersSize) {
        int index = 0;

        if (command.equals("Insert")) {
            index = Integer.parseInt(input.split("\\s+")[2]);
        } else if (command.equals("Remove")) {
            index = Integer.parseInt(input.split("\\s+")[1]);
        }

        return index >= 0 && index <= numbersSize;
    }

    private static void printNumbers(List<Integer> numbers) {
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> removeAtIndex(List<Integer> numbers, String input) {
        int indexToRemove = Integer.parseInt(input.split("\\s+")[1]);
        numbers.remove(indexToRemove);

        return numbers;
    }

    private static List<Integer> shiftNumber(List<Integer> numbers, String input) {
        String leftOrRight = input.split("\\s+")[1];
        int count = Integer.parseInt(input.split("\\s+")[2]);
        if (leftOrRight.equals("left")) {
            numbers = shiftLeft(numbers, count);
        } else if (leftOrRight.equals("right")) {
            numbers = shiftRight(numbers, count);
        }

        return numbers;
    }

    private static List<Integer> insertNumber(List<Integer> numbers, String input) {
        int numberToAdd = Integer.parseInt(input.split("\\s+")[1]);
        int index = Integer.parseInt(input.split("\\s+")[2]);
        numbers.add(index, numberToAdd);

        return numbers;
    }

    private static List<Integer> addNumber(List<Integer> numbers, String input) {
        int numberToAdd = Integer.parseInt(input.split("\\s+")[1]);
        numbers.add(numberToAdd);

        return numbers;
    }

    private static List<Integer> shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int lastNumber = numbers.get(numbers.size() - 1);
            numbers.remove(numbers.size() - 1);
            numbers.add(0, lastNumber);
        }

        return numbers;
    }

    private static List<Integer> shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int firstNumber = numbers.get(0);
            numbers.remove(0);
            numbers.add(Integer.valueOf(firstNumber));
        }

        return numbers;
    }
}
