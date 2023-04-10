package Exercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int badResults = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int gradeSum = 0;
        int badResultsCount = 0;
        int gradesAmount = 0;
        boolean isPassed = true;
        String lastExam = "";

        while (!input.equals("Enough")) {
            int currentGrade = Integer.parseInt(scanner.nextLine());
            gradeSum += currentGrade;
            gradesAmount++;
            lastExam = input;

            if (currentGrade <= 4) {
                badResultsCount++;
            }

            if (badResultsCount == badResults) {
                isPassed = false;

                System.out.printf("You need a break, %d poor grades.", badResults);
                break;
            }

            input = scanner.nextLine();
        }

        if (isPassed){
            double averageScore = 1.0 * gradeSum / gradesAmount;
            System.out.printf("Average score: %.2f%n", averageScore);
            System.out.printf("Number of problems: %d%n", gradesAmount);
            System.out.printf("Last problem: %s", lastExam);
        }
    }
}
