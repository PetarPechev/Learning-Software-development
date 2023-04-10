package Exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double biggestKegVolume = Double.MIN_VALUE;

        for (int i = 0; i < numberOfKegs; i++) {
            String modelOfCurrentKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (biggestKegVolume < volume) {
                biggestKegVolume = volume;
                biggestKeg = modelOfCurrentKeg;
            }
        }

        System.out.print(biggestKeg);
    }
}
