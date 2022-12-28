package Lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        calculatePrice(product, quantity);
    }

    private static void calculatePrice(String product, int quantity) {
        double pricePerOneProduct = 0;

        switch (product){
            case "coffee":
                pricePerOneProduct = 1.50;
                break;
            case "water":
                pricePerOneProduct = 1.00;
                break;
            case "coke":
                pricePerOneProduct = 1.40;
                break;
            case "snacks":
                pricePerOneProduct = 2.00;
                break;
        }

        double totalPrice = pricePerOneProduct * quantity;

        System.out.printf("%.2f", totalPrice);
    }
}
