package Exercise;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> minedResources = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();

            if (name.equals("stop")) {
                break;
            }

            String email = scanner.nextLine();

            boolean isContained = email.endsWith(".us") || email.endsWith(".com") || email.endsWith(".uk");

            if (!isContained) {
                minedResources.put(name, email);

            }
        }

        minedResources.forEach((name, email) -> System.out.println(name + " -> " + email));
    }
}
