package Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double georgeMoneys = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double moneyNeeded = ((Math.ceil(countOfStudents * 1.1) * lightsaberPrice) +
                                (countOfStudents * robesPrice) +
                                ((countOfStudents - Math.floor(countOfStudents / 6)) * beltPrice));

        if (moneyNeeded <= georgeMoneys) {
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", moneyNeeded - georgeMoneys);
        }
    }
}
