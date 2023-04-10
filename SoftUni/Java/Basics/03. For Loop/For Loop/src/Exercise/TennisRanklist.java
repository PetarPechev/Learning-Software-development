package Exercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfTournaments = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int wonTournaments = 0;

        for (int i = 0; i < amountOfTournaments; i++) {
            String place = scanner.nextLine();

            switch (place){
                case "W":
                    points+= 2000;
                    wonTournaments++;
                    break;
                case "F":
                    points+= 1200;
                    break;
                case "SF":
                    points+= 720;
                    break;
            }
        }
        int finalPoints = points + startPoints;
        int averagePoints = points / amountOfTournaments;
        double percentageOfWonTournaments = (1.0 * wonTournaments / amountOfTournaments) * 100;

        System.out.printf("Final points: %d%n", finalPoints);
        System.out.printf("Average points: %d%n", averagePoints);
        System.out.printf("%.2f%%", percentageOfWonTournaments);
    }
}
