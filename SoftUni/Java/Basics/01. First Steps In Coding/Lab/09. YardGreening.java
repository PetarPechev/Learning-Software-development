package Lab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sqMetersForHarvesting = Double.parseDouble(scanner.nextLine());
        double pricePerSquareMeter = 7.61;
        double discountPercentage = 0.18;
        double priceWithoutDiscount = sqMetersForHarvesting * pricePerSquareMeter;
        double discount = priceWithoutDiscount * discountPercentage;
        double priceWithDiscount = priceWithoutDiscount - discount;

        System.out.printf("The final price is: %.2f lv.\n", priceWithDiscount);
        System.out.printf("The final price is: %.2f lv.", discount);
    }
}
