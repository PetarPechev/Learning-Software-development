package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOFStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsWithGrades = new TreeMap<>();

        for (int i = 0; i < countOFStudents; i++) {
            String student = scanner.nextLine();

            List<Double> grades = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentsWithGrades.put(student, grades);
        }

        printGraduation(studentsWithGrades);
    }

    private static void printGraduation(Map<String, List<Double>> studentsWithGrades) {
        studentsWithGrades.forEach((student, grades) -> {
            System.out.println(student + " is graduated with " + getAvg(grades));
        });

//        for (Map.Entry<String, List<Double>> student : studentsWithGrades.entrySet()) {
//            System.out.println(student.getKey() + " is graduated with " + getAvg(student.getKey()));
//        }
    }

    private static double getAvg(List<Double> grades) {
        double sum = 0;

        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
