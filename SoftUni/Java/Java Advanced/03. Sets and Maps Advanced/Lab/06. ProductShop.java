package Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopData = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopData.putIfAbsent(shop, new LinkedHashMap<>());
            shopData.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        shopData.forEach((shop, productsData) -> {
            System.out.println(shop + "->");
            productsData.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });

        // alternative variant of printing shopData
        //printShopData(shopData);
    }

//    private static void printShopData(Map<String, Map<String, Double>> shopData) {
//        for (Map.Entry<String, Map<String, Double>> shop : shopData.entrySet()) {
//            System.out.println(shop.getKey() + "->");
//
//            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
//                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
//
//            }
//        }
//    }
}
