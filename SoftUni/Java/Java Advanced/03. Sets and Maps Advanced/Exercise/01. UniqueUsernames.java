package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int countInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countInputs; i++) {
            usernames.add(scanner.nextLine());
        }

        usernames.forEach(System.out::println);
    }
}
