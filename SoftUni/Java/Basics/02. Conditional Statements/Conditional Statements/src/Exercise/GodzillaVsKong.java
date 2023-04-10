package Exercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int peoplesCount = Integer.parseInt(scanner.nextLine());
        double priceForClothes = Double.parseDouble(scanner.nextLine());

        double decorPrice = budget * 0.1;
        double totalPriceForClothes = peoplesCount * priceForClothes;

        if (peoplesCount > 150) {
            totalPriceForClothes -= totalPriceForClothes * 0.1;
        }

        double expenses = decorPrice + totalPriceForClothes;

        if (expenses > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", expenses - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - expenses);
        }
    }
}
