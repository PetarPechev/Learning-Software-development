package Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesAndStudents = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            coursesAndStudents.putIfAbsent(course, new ArrayList<>());
            coursesAndStudents.get(course).add(studentName);

            input = scanner.nextLine();
        }

        printCoursesAndStudents(coursesAndStudents);
    }

    private static void printCoursesAndStudents(Map<String, List<String>> coursesAndStudents) {
        for (Map.Entry<String, List<String>> course : coursesAndStudents.entrySet()) {
            System.out.printf("%s: %d%n", course.getKey(), course.getValue().size());

            for (String student : course.getValue()) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
