package Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfNames = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < countOfNames; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double grade = Double.parseDouble(input[1]);

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsGrades.get(studentName).add(grade);
        }

        printStudentGrades(studentsGrades);
    }

    private static void printStudentGrades(Map<String, List<Double>> studentsGrades) {
        for (Map.Entry<String, List<Double>> student : studentsGrades.entrySet()) {
            System.out.print(student.getKey() + " -> ");

            for (Double grade : student.getValue()) {
                System.out.printf("%.2f ", grade);
            }

            double averageGrade = student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }
    }

}
