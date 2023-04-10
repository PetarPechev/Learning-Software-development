package Exercise;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pensCount = Integer.parseInt(scanner.nextLine());
        int markersCount = Integer.parseInt(scanner.nextLine());
        int cleaningChemicalCount = Integer.parseInt(scanner.nextLine());
        double discountPercentage = Double.parseDouble(scanner.nextLine()) / 100;

        double pensPrice = 5.8;
        double markersPrice = 7.2;
        double cleaningChemicalPrice = 1.2;

        double totalPriceWithoutDiscount = (pensCount * pensPrice +
                markersCount * markersPrice +
                cleaningChemicalCount * cleaningChemicalPrice);

        double totalPriceWithDiscount = totalPriceWithoutDiscount - totalPriceWithoutDiscount * discountPercentage;

        System.out.println(totalPriceWithDiscount);
    }
}
