package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.contains("Delete")) {
                int numbersToDelete = Integer.parseInt(input.split("\\s+")[1]);
                numbers.removeAll(List.of(numbersToDelete));
            } else if (input.contains("Insert")){
                int numberToAdd = Integer.parseInt(input.split("\\s+")[1]);
                int index = Integer.parseInt(input.split("\\s+")[2]);
                numbers.add(index, numberToAdd);
            }

            input = scanner.nextLine();
        }

        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
