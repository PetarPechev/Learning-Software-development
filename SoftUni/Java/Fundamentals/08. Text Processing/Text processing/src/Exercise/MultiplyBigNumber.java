package Exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        BigInteger result = firstNum.multiply(BigInteger.valueOf(secondNum));

        System.out.println(result);
    }
}
