package Lab;

import java.util.ArrayDeque;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.print(0);
        }

        while (decimalNumber > 0 ){
            binaryNumber.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        for (Integer binary : binaryNumber) {
            System.out.print(binary);
        }
    }
}
