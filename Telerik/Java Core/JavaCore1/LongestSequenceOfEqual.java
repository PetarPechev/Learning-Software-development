package JavaCore1;

import java.util.Scanner;

/*Longest Sequence of Equal
        Description
        Write a program that finds the length of the maximal sequence of equal elements in an array of N integers.

        Input
        On the first line you will receive the number N
        On the next N lines the numbers of the array will be given
        Output
        Print the length of the maximal sequence
        Constraints
        1 <= N <= 1024
        Sample tests
        Input
        10
        2
        1
        1
        2
        3
        3
        2
        2
        2
        1
        Output
        3*/
public class LongestSequenceOfEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];

        fillNumbersArr(numbers, n, scanner);
        getBiggestSequence(numbers, n);
    }

    private static void fillNumbersArr(int[] numbers, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    private static void getBiggestSequence(int[] numbers, int n) {
        int counter = 1;
        int maxSequence = 0;

        for (int i = 1; i < n; i++) {
            if (numbers[i-1] == numbers[i]) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter > maxSequence) {
                maxSequence = counter;
            }
        }

        System.out.print(maxSequence);
    }
}