package Exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int spiceMined = 0;
        int days = 0;

        while (startingYield >= 100) {
            spiceMined += startingYield;
            days++;

            if (spiceMined - 26 >= 0){
                spiceMined -= 26;
            }

            startingYield -= 10;
        }

        if (spiceMined - 26 >= 0){
            spiceMined -= 26;
        }

        System.out.println(days);
        System.out.println(spiceMined);
    }
}
