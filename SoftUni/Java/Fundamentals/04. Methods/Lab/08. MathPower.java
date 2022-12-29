package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = calculateNumberWithPower(number, power);
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(result));
    }

    private static double calculateNumberWithPower(double number, int power) {
        double result = number;

        for (int i = 1; i < power; i++) {
            result *= number;
        }

        return result;
    }
}
