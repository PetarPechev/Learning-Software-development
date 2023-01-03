package Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int productsCount = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < productsCount; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }

        Collections.sort(products);

        printProducts(products);
    }

    private static void printProducts(List<String> products) {
        for (int i = 1; i <= products.size(); i++) {
            System.out.printf("%d.%s%n", i, products.get(i - 1));
        }
    }
}
