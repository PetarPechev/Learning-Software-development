import java.util.Arrays;
import java.util.Scanner;

/*Big Numbers
        Description
        Write a method that adds two positive integer numbers represented as arrays of digits (each array element arr[i] contains a digit; the last digit is kept in arr[0]). Write a program that reads two arrays representing positive integers and outputs their sum.

        Input
        On the first line you will receive two numbers separated by spaces - the size of each array
        On the second line you will receive the first array
        On the third line you will receive the second array
        Output
        Print the sum as an array of digits (as described)
        Digits should be separated by spaces
        Constraints
        Each of the numbers that will be added could have up to 10 000 digits.
        Sample tests
        Input
        3 4
        8 3 3
        6 2 4 2
        Output
        4 6 7 2
        Input
        5 5
        0 3 9 3 2
        5 9 5 1 7
        Output
        5 2 5 5 9*/
public class BigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = new int[scanner.nextInt()];
        int[] secondArr = new int[scanner.nextInt()];

        fillArrayWithNums(firstArr, scanner);
        fillArrayWithNums(secondArr, scanner);

        int[] result = new int[Math.max(firstArr.length, secondArr.length)];

        int remaining = 0;

        for (int index = 0; index < result.length; index++){

            int sum = getSumOfElements(firstArr, secondArr, index, remaining);

            result[index] = sum % 10;
            remaining = sum / 10;
        }

        System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
    }

    private static int getSumOfElements(int[] firstArr, int[] secondArr, int index, int remaining) {
        int firstArrNum = index < firstArr.length ? firstArr[index] : 0;
        int secondArrNum = index < secondArr.length ? secondArr[index] : 0;

        return firstArrNum + secondArrNum + remaining;
    }

    private static void fillArrayWithNums(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }
}