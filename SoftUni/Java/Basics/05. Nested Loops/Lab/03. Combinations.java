package Lab;

import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int x = 0; x <= number; x++) {
            for (int y = 0; y <= number; y++) {
                for (int z = 0; z <= number; z++) {
                    int sum = x + y + z;

                    if (sum == number) {
                        counter++;
                    }
                }
            }
        }

        System.out.println(counter);
    }
}
