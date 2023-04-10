package Lab;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age >= 0 && age <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
                default:
                    System.out.print("Error!");
                    break;
            }
            System.out.printf("%d$", price);

        } else if (age > 18 && age <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
                default:
                    System.out.print("Error!");
                    break;
            }
            System.out.printf("%d$", price);

        } else if (age > 64 && age <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
                default:
                    System.out.printf("Error!");
                    break;
            }
            System.out.printf("%d$", price);
        }
        else {
            System.out.print("Error!");
        }
    }
}
