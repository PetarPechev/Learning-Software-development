package Exercise;

import java.util.Scanner;

public class WaterOverFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int waterFilled = 0;

        for (int i = 0; i < lines; i++) {
            int waterToPour = Integer.parseInt(scanner.nextLine());

            if (waterToPour + waterFilled > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                waterFilled += waterToPour;
            }
        }

        System.out.print(waterFilled);
    }
}
