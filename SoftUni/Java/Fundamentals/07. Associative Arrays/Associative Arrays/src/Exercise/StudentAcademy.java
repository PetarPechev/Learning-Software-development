package Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsGrades.get(studentName).add(grade);
        }

        studentsGrades.entrySet().removeIf(e -> getAvg(e.getValue()) < 4.50);
        printStudentsWithGrades(studentsGrades);
    }

    private static double getAvg(List<Double> value) {
        return value.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    private static void printStudentsWithGrades(Map<String, List<Double>> studentsGrades) {
        for (Map.Entry<String, List<Double>> student : studentsGrades.entrySet()) {
            double averageGrade = student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("%s -> %.2f%n", student.getKey(), averageGrade);
        }
    }
}
