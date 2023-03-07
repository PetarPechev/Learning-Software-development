package Exercise;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, BigInteger> minedResources = new LinkedHashMap<>();

        while (true) {
            String resource = scanner.nextLine();

            if (resource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scanner.nextLine());
            minedResources.putIfAbsent(resource, BigInteger.ZERO);
            minedResources.put(resource, minedResources.get(resource).add(BigInteger.valueOf(quantity)));
        }

        minedResources.forEach((resource, quantity) -> System.out.println(resource + " -> " + quantity));

    }
}
