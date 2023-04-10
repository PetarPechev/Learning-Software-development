package Exercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int priceForTraining = Integer.parseInt(scanner.nextLine());

        double shoesPrice = priceForTraining - priceForTraining * 0.4;
        double clothesPrice = shoesPrice - shoesPrice * 0.2;
        double ballPrice = clothesPrice / 4;
        double accessoriesPrice = ballPrice / 5;

        double totalPrice = priceForTraining + shoesPrice + clothesPrice + ballPrice + accessoriesPrice;

        System.out.println(totalPrice);
    }
}
