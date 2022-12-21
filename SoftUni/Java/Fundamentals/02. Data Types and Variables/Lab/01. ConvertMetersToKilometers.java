package Lab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int metres = Integer.parseInt(scanner.nextLine());
        double kilometers = metres / 1000.0;

        System.out.printf("%.2f", kilometers);
    }
}
