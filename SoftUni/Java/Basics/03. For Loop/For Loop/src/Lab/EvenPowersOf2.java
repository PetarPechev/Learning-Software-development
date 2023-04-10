package Lab;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int pow = 0; pow <= n; pow+=2) {
            System.out.println((int)Math.pow(2, pow));
        }
    }
}
