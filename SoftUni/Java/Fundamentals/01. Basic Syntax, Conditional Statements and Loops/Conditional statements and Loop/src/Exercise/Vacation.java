package Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCountOfMembers = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double  price = 0.0;
        double totalPrice = 0.0;

        if (typeOfGroup.equals("Students")) {
            switch (day) {
                case "Friday":
                    price = 8.45;
                    break;
                case "Saturday":
                    price = 9.80;
                    break;
                case "Sunday":
                    price = 10.46;
                    break;
            }

            totalPrice = groupCountOfMembers * price;

            if (groupCountOfMembers >= 30) {
                totalPrice = totalPrice - (totalPrice * 0.15);
            }
        } else if (typeOfGroup.equals("Business")) {
            switch (day) {
                case "Friday":
                    price = 10.90;
                    break;
                case "Saturday":
                    price = 15.60;
                    break;
                case "Sunday":
                    price = 16;
                    break;
            }

            totalPrice = groupCountOfMembers * price;

            if (groupCountOfMembers >= 100) {
                totalPrice = totalPrice - (price * 10);
            }
        } else if (typeOfGroup.equals("Regular")) {
            switch (day) {
                case "Friday":
                    price = 15;
                    break;
                case "Saturday":
                    price = 20;
                    break;
                case "Sunday":
                    price = 22.50;
                    break;
            }

            totalPrice = groupCountOfMembers * price;

            if (groupCountOfMembers >= 10 && groupCountOfMembers <= 20) {
                totalPrice = totalPrice - (totalPrice * 0.05);
            }
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
