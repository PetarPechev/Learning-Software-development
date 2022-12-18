package Exercise;

import javax.print.attribute.standard.MediaSize;
import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")) {
            int currentNumber = Integer.parseInt(input);

            if (currentNumber < 0 ) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            boolean isPrime = true;

            for(int i = 2; i <= currentNumber / 2; i++){
                if(currentNumber % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                sumPrime += currentNumber;
            } else {
                sumNonPrime += currentNumber;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d", sumNonPrime);
    }
}
