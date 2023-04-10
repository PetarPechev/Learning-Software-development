package Exercise;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWashingMachine = Double.parseDouble(scanner.nextLine());
        int pricePerToy = Integer.parseInt(scanner.nextLine());
        double moneyToReceive = 10.0;
        double sum = 0.0;
        int toysCount = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                sum += moneyToReceive - 1;
                moneyToReceive += 10;
            } else {
                toysCount++;
            }
        }

        sum += pricePerToy * toysCount;
        double difference = Math.abs(sum - priceWashingMachine);

        if (sum >= priceWashingMachine) {
            System.out.printf("Yes! %.2f", difference);
        } else {
            System.out.printf("No! %.2f", difference);
        }
    }
}
