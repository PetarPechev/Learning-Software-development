package Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());
        BigInteger result = BigInteger.ZERO;

        result = result.add(BigInteger.valueOf(firstNumber))
                .add(BigInteger.valueOf(secondNumber))
                .divide(BigInteger.valueOf(thirdNumber))
                .multiply(BigInteger.valueOf(fourthNumber));

        System.out.print(result);
    }
}
