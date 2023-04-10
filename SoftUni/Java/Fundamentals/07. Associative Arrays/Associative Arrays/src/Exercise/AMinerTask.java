package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> minedResources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resources = input;
            Integer quantity = Integer.parseInt(scanner.nextLine());

            minedResources.putIfAbsent(resources, 0);
            minedResources.put(resources, minedResources.get(resources) + quantity);

            input = scanner.nextLine();
        }

        minedResources.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
