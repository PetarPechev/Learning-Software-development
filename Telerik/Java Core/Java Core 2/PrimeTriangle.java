package JavaCore2;

import java.util.Scanner;


/*Prime Triangle
        Description
        We know that you love math, so we have prepared a very interesting task, that involves both geometry and prime numbers.

        By a given N number, from which you need to generate a sequence of 1 to N inclusive. For every prime number in that sequence, you need to print out all the other numbers before it (and the number itself), whether they are prime or not

        Note:
        For the purposes of this task (and against the laws of mathematics), the number 1 is considered as prime.

        Example
        Let's say N=10

        We have the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        The prime numbers are 1, 2, 3, 5, 7 - 5 prime numbers, so we print 5 rows
        Each row contains all the numbers for 1 to PRIME_NUMBER
        Result:

        1
        1 2
        1 2 3
        1 2 3 4 5
        1 2 3 4 5 6 7

        Let's make things simpler:

        Print 0 if the numbers is not prime
        Print 1 if the number is prime
        Final result:

        1
        1 1
        1 1 1
        1 1 1 0 1
        1 1 1 0 1 0 1

        Input
        Read from the standard input
        On the single line, find the number N
        The input data will always be valid and in the format described. There is no need to check it explicitly
        Output
        Print on the standard output
        The output should consist of several lines of digits each of which can be either 1 or 0
        Without any space between them
        Sample tests
        Input
        10
        Output
        1
        11
        111
        11101
        1110101
        Input
        27
        Output
        1
        11
        111
        11101
        1110101
        11101010001
        1110101000101
        11101010001010001
        1110101000101000101
        11101010001010001010001*/

public class PrimeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            if (isPrime(number)) {
                printZeroOrOne(number);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) {
                return false;
            }

        return true;
    }

    private static void printZeroOrOne(int number) {
        for (int i = 1; i <= number; i++) {
            if (isPrime(i)) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

        System.out.println();
    }
}