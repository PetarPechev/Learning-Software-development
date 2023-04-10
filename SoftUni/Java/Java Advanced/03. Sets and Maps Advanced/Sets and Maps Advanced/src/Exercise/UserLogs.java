package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String ip = input.split("\\s+")[0].replace("IP=", "");
            String user = input.split("\\s+")[2].replace("user=", "");

            addUserLogs(userLogs, user, ip);

            input = scanner.nextLine();
        }

        printUserLogs(userLogs);
    }

    private static void addUserLogs(Map<String, Map<String, Integer>> userLogs, String user, String ip) {
        userLogs.putIfAbsent(user, new LinkedHashMap<>());
        userLogs.get(user).putIfAbsent(ip, 0);
        int messagesCount = userLogs.get(user).get(ip) + 1;
        userLogs.get(user).put(ip, messagesCount);
    }

    private static void printUserLogs(Map<String, Map<String, Integer>> userLogs) {
        for (Map.Entry<String, Map<String, Integer>> user : userLogs.entrySet()) {
            System.out.println(user.getKey() + ":");
            int counter = 1;

            for (Map.Entry<String, Integer> ip : user.getValue().entrySet()) {
                if (counter < user.getValue().size()) {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ", ");
                } else {
                    System.out.println(ip.getKey() + " => " + ip.getValue() + ".");
                }
                counter++;
            }
        }
    }
}
