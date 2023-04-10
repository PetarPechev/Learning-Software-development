package Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogsAmountOfFood = Integer.parseInt(scanner.nextLine());
        int catsAmountOfFood = Integer.parseInt(scanner.nextLine());
        double totalPriceForDogsFood = dogsAmountOfFood * 2.5;
        double totalPriceForCatsFood = catsAmountOfFood * 4.0;
        double totalMoneysNeeded = totalPriceForCatsFood + totalPriceForDogsFood;

        System.out.printf("%f lv.", totalMoneysNeeded);
    }
}
