package Exercise;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double points = Double.parseDouble(scanner.nextLine());
        int amountOfReferees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < amountOfReferees; i++) {
            String nameOfReferee = scanner.nextLine();
            double pointsFromReferee = Double.parseDouble(scanner.nextLine());

            points += (nameOfReferee.length() * pointsFromReferee) / 2;

            if (points >= 1250.5) {
                break;
            }
        }

        if (points >= 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, points);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - points);
        }
    }
}
