package Exercise;

import java.util.*;


public class SoftUniExamResults {
    public static class Student {
        private String username;
        private String language;
        private int points;

        public Student(String username, String language, int points) {
            this.username = username;
            this.language = language;
            this.points = points;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {
            boolean isExist = false;

            if (command.contains("banned")) {
                removeStudent(students, command);
            } else {
                addStudent(students, command, isExist, submissions);
            }

            command = scanner.nextLine();
        }

        printResult(students, submissions);
    }

    private static void addStudent(List<Student> students, String command, boolean isExist, Map<String, Integer> submissions) {
        String username = command.split("-")[0];
        String language = command.split("-")[1];
        int points = Integer.parseInt(command.split("-")[2]);
        Student student = new Student(username, language, points);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(username) && students.get(i).getLanguage().equals(language)) {
                if (students.get(i).getPoints() < points) {
                    students.set(i, student);
                }
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            students.add(student);
        }

        addSubmission(submissions, language);
    }

    private static void addSubmission(Map<String, Integer> submissions, String language) {
        submissions.putIfAbsent(language, 0);
        submissions.put(language, submissions.get(language) + 1);
    }

    private static void removeStudent(List<Student> students, String command) {
        String username = command.split("-")[0];
        students.removeIf(s -> s.getUsername().equals(username));
    }

    private static void printResult(List<Student> students, Map<String, Integer> submissions) {
        if (!students.isEmpty()) {
            System.out.println("Results:");
            students.forEach(s -> System.out.println(s.getUsername() + " | " + s.getPoints()));
        }

        System.out.println("Submissions:");
        submissions.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}