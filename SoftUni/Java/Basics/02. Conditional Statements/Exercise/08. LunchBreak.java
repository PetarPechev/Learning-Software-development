package Exercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int movieLength = Integer.parseInt(scanner.nextLine());
        int restLength = Integer.parseInt(scanner.nextLine());
        double freeTime = restLength - (restLength / 8.0 + restLength / 4.0);
        double timeDifference = Math.ceil(Math.abs(movieLength - freeTime));

        if (freeTime >= movieLength) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    movieName, timeDifference);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    movieName, timeDifference);
        }
    }
}
