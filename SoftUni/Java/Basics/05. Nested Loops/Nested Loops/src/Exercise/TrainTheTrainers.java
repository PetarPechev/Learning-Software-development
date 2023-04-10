package Exercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;
        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals("Finish")){

            double averageGrade = 0.0;
            counter++;

            for (int i = 1; i <= n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                averageGrade += grade;
            }

            averageGrade = averageGrade / n;
            sum += averageGrade;

            System.out.printf("%s - %.2f.%n", input, averageGrade);

            input = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.", sum / counter);
    }
}
