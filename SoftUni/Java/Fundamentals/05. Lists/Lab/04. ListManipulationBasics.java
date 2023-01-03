package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputAsArray = input.split("\\s+");

            numbers = manipulateList(numbers, inputAsArray);

            input = scanner.nextLine();
        }

        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> manipulateList(List<Integer> numbers, String[] inputAsArray) {
        String command = inputAsArray[0];

        switch (command) {
            case "Add":
                int numberToAdd = Integer.parseInt(inputAsArray[1]);
                numbers.add(numberToAdd);
                break;
            case "Remove":
                int numberToRemove = Integer.parseInt(inputAsArray[1]);
                numbers.remove(Integer.valueOf(numberToRemove));
                break;
            case "RemoveAt":
                int removeAtIndex = Integer.parseInt(inputAsArray[1]);
                numbers.remove(removeAtIndex);
                break;
            case "Insert":
                int number = Integer.parseInt(inputAsArray[1]);
                int index = Integer.parseInt(inputAsArray[2]);
                numbers.add(index, number);
                break;
        }

        return numbers;
    }
}
