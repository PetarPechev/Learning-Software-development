package Exercise;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double lengthInMeters = Double.parseDouble(scanner.nextLine());
        double neededTimeForOneMeter = Double.parseDouble(scanner.nextLine());
        double delayInSeconds = Math.floor(lengthInMeters / 15) * 12.5;

        double timeToSwimInSeconds = lengthInMeters * neededTimeForOneMeter + delayInSeconds;

        if (timeToSwimInSeconds < recordInSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeToSwimInSeconds);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeToSwimInSeconds - recordInSeconds);
        }
    }
}
