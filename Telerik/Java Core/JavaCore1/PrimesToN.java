package JavaCore1;

import java.util.Scanner;

/*Primes to N
        Description
        Print all the prime numbers between 1 and N

        Input
        Read from the standard input

        On the single line, read the number *
        Output
        Print on the standard output

        Print all the prime numbers, separated by a single whitespace
        Constraints
        1 <= N <= 1024
        1 is considered prime
        Sample tests
        Input
        15
        Output
        1 2 3 5 7 11 13
        Input
        24
        Output
        1 2 3 5 7 11 13 17 19 23*/

public class PrimesToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                return false;
            }

        return true;
    }
}
