import java.util.Arrays;
import java.util.Scanner;

/*Reverse Array
        You are given an array of numbers. Your task is to reverse it.

        Input
        Read from the standard input

        Receive the numbers on the first line of the input, separated by whitespace.
        Output
        Print to the standard output

        Print the reversed array in a single line. Separate the numbers in the array a comma and whitespace.
        Sample tests
        Input
        1 2 3 4 5 6 7
        Output
        7, 6, 5, 4, 3, 2, 1*/
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length / 2; i++) {
            int leftNum = numbers[i];
            int rightNum = numbers[numbers.length - 1 - i];

            numbers[i] = rightNum;
            numbers[numbers.length - 1 - i] = leftNum;
        }

        System.out.print(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}
