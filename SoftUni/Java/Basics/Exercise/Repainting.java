package Exercise;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylonAmount = Integer.parseInt(scanner.nextLine()) + 2;
        double paintAmount = Double.parseDouble(scanner.nextLine()) * 1.1;
        int diluentAmount = Integer.parseInt(scanner.nextLine());
        int hoursNeeded = Integer.parseInt(scanner.nextLine());

        double nylonPrice = 1.5;
        double paintPrice = 14.5;
        double diluentPrice = 5.0;
        double workPrice = 0.3;
        double bagsPrice = 0.4;

        double priceForMaterials = (nylonAmount * nylonPrice +
                paintAmount * paintPrice
                + diluentAmount * diluentPrice +
                bagsPrice);
        double priceForWorkman = (priceForMaterials * workPrice) * hoursNeeded;
        double totalSum = priceForMaterials + priceForWorkman;

        System.out.println(totalSum);
    }
}
