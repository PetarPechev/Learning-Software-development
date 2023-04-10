package Exercise;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine()) / 100;

        double aquariumVolume = length * width * height;
        double volumeInLiters = aquariumVolume / 1000;
        double volumeForOtherItems = volumeInLiters * percentage;
        double waterLiterNeeded = volumeInLiters - volumeForOtherItems;

        System.out.println(waterLiterNeeded);
    }
}
