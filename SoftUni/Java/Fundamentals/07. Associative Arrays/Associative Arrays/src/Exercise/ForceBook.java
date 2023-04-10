package Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceBook = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" | ")) {
                String side = input.split("\\s+\\|\\s+")[0];
                String user = input.split("\\s+\\|\\s+")[1];

                if (!isExistingUser(forceBook, user)) {
                    addUser(forceBook, side, user);
                }

            } else if (input.contains(" -> ")) {
                String user = input.split("\\s+->\\s+")[0];
                String side = input.split("\\s+->\\s+")[1];
                forceBook.forEach((key, value) -> value.remove(user));
                addUser(forceBook, side, user);
                System.out.printf("%s joins the %s side!%n", user, side);
            }

            input = scanner.nextLine();
        }

        printForceBook(forceBook);
    }

    private static void printForceBook(Map<String, List<String>> forceBook) {
        for (Map.Entry<String, List<String>> side : forceBook.entrySet()) {
            int countOfUsers = side.getValue().size();

            if (countOfUsers > 0) {
                System.out.printf("Side: %s, Members: %d%n", side.getKey(), countOfUsers);
                side.getValue().forEach(user -> System.out.println("! " + user));
            }
        }
    }

    private static void addUser(Map<String, List<String>> forceBook, String side, String user) {
        forceBook.putIfAbsent(side, new ArrayList<>());
        forceBook.get(side).add(user);
    }

    private static boolean isExistingUser(Map<String, List<String>> forceBook, String user) {
        for (Map.Entry<String, List<String>> side : forceBook.entrySet()) {
            if (side.getValue().contains(user)) {
                return true;
            }
        }

        return false;
    }
}
