package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("end")) {

            if (input[0].equals("swap")) {
                int firstIndex = Integer.parseInt(input[1]);
                int secondIndex = Integer.parseInt(input[2]);
                int firstElement = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = firstElement;
            } else if (input[0].equals("multiply")) {
                int firstIndex = Integer.parseInt(input[1]);
                int secondIndex = Integer.parseInt(input[2]);
                numbers[firstIndex] *= numbers[secondIndex];
            } else if (input[0].equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;
                };
            }

            input = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1){
                System.out.print(numbers[i] + ", ");
            } else {
                System.out.print(numbers[i]);
            }
        }
    }
}
