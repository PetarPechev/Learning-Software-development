package Lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double sum = 0.0;
        boolean isGraduated = true;

        for (int i = 1; i <= 12; i++) {
            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (currentGrade < 4.00) {
                System.out.printf("%s has been excluded at %d grade%n", name, i);
                isGraduated = false;
                break;
            }
            sum+= currentGrade;
        }

        if (isGraduated) {
            double averageGrade = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }
    }
}
