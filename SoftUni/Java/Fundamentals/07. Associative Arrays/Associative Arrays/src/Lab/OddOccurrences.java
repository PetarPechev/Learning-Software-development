package Lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputElements = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(String::toLowerCase)
                .toArray(String[]::new);

        Map<String, Integer> occurrences = new LinkedHashMap<>();

        for (String element : inputElements) {
            occurrences.putIfAbsent(element, 0);
            occurrences.put(element, occurrences.get(element) + 1);
        }

        List<String> oddOccurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> element : occurrences.entrySet()) {
            if (element.getValue() % 2 != 0) {
                oddOccurrences.add(element.getKey());
            }
        }

        System.out.print(String.join(", ", oddOccurrences));
    }
}
