package Exercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excursionPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());
        int totalToysCount = puzzlesCount + dollsCount + bearsCount + minionsCount + trucksCount;

        double puzzlePrice = 2.6;
        double dollsPrice = 3.0;
        double bearsPrice = 4.1;
        double minionsPrice = 8.2;
        double truckPrice = 2.0;

        double sum = puzzlesCount * puzzlePrice + dollsCount * dollsPrice + bearsCount * bearsPrice +
                minionsCount * minionsPrice + trucksCount * truckPrice;

        if (totalToysCount >= 50) {
            sum -= sum * 0.25;
        }

        sum -= sum * 0.1;

        if (sum >= excursionPrice) {
            System.out.printf("Yes! %.2f lv left.", sum - excursionPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", excursionPrice - sum);
        }

    }
}
