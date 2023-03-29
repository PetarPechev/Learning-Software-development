import java.util.Arrays;
import java.util.Scanner;

/*Symmetric Arrays
        You are given some arrays of numbers. Your task is to check if they are symmetric. A symmetric array is one, where the element at index x is equal to the element at index array.length - 1 - x.

        Input
        Read from the standard input.

        On the first line, read the number N - the number of arrays to follow.
        On the N lines, read the elements of each array, separated by white space.
        Output
        Print to the standard output.

        For each of the arrays, print Yes of the array is symmetric, or No if it's not.
        Sample tests
        Input
        4
        1 2 3 2 1
        2 1
        1 2 2 1
        4
        Output
        Yes
        No
        Yes
        Yes*/
public class SymmetricArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfArrays = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numOfArrays; i++) {
            int[] numbers = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(isSymmetricArray(numbers));
        }
    }

    private static String isSymmetricArray(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            if (numbers[i] != numbers[numbers.length - 1 - i]) {
                return "No";
            }
        }

        return "Yes";
    }
}
