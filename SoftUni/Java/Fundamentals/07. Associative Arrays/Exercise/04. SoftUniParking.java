package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> usersData = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String userName = input[1];

            if (command.equals("register")) {
                String plateNumber = input[2];
                registerUser(usersData, userName, plateNumber);
            } else if (command.equals("unregister")) {
                unregisterUser(usersData, userName);
            }
        }

        usersData.forEach((key, value) -> System.out.println(key + " => " + value));
    }

    private static void unregisterUser(Map<String, String> usersData, String userName) {
        if (usersData.containsKey(userName)) {
            System.out.printf("%s unregistered successfully%n", userName);
            usersData.remove(userName);
        } else {
            System.out.printf("ERROR: user %s not found%n", userName);
        }
    }

    private static void registerUser(Map<String, String> usersData, String userName, String plateNumber) {
        if (usersData.containsKey(userName)) {
            System.out.printf("ERROR: already registered with plate number %s%n", usersData.get(userName));
        } else {
            usersData.put(userName, plateNumber);
            System.out.printf("%s registered %s successfully%n", userName, plateNumber);
        }
    }
}
