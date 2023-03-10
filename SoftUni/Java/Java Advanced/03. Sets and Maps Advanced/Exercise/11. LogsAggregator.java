package Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> usersWithTime = new TreeMap<>();
        TreeMap<String, TreeSet<String>> addresses = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            usersWithTime.putIfAbsent(name, 0);
            addresses.putIfAbsent(name, new TreeSet<>());

            usersWithTime.put(name, usersWithTime.get(name) + time);
            addresses.get(name).add(ip);
        }

        usersWithTime.forEach((key, value) -> {
            System.out.printf("%s: %d %s%n", key, value, addresses.get(key).toString());
        });
    }
}