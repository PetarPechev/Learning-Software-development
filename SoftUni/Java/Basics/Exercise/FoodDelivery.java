package Exercise;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenFoods = Integer.parseInt(scanner.nextLine());
        int fishFoods = Integer.parseInt(scanner.nextLine());
        int veganFoods = Integer.parseInt(scanner.nextLine());

        double chickenFoodPrice = 10.35;
        double fishFoodPrice = 12.40;
        double veganFoodPrice = 8.15;
        double deliveryPrice = 2.50;
        double orderPriceWithoutDesert = chickenFoods * chickenFoodPrice +
                fishFoods * fishFoodPrice +
                veganFoods * veganFoodPrice;
        double desertPrice = orderPriceWithoutDesert * 0.2;

        double totalSum = orderPriceWithoutDesert + desertPrice + deliveryPrice;

        System.out.println(totalSum);
    }
}
