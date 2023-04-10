package Exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int halfOfOriginalPower = power / 2;
        int targetsPoked = 0;

        while (power >= distance){
            power -= distance;
            targetsPoked++;

            if (power == halfOfOriginalPower && exhaustionFactor != 0){
                power /= exhaustionFactor;
            }
        }

        System.out.println(power);
        System.out.println(targetsPoked);
    }
}
