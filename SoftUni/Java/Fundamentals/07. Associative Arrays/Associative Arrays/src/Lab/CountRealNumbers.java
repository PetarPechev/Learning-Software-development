package Lab;

import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbersInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersCount = new TreeMap<>();

        for (int i = 0; i < numbersInput.length; i++) {
            double currentNumber = numbersInput[i];
            fillTreeMap(numbersCount, currentNumber);
        }

        printTreeMap(numbersCount);
    }

    private static void fillTreeMap(Map<Double, Integer> numbersCount, double currentNumber) {
        if (!numbersCount.containsKey(currentNumber)) {
            numbersCount.put(currentNumber, 0);
        }

        numbersCount.put(currentNumber, numbersCount.get(currentNumber) + 1);
    }

    private static void printTreeMap(Map<Double, Integer> numbersCount) {
        for (Map.Entry<Double, Integer> number : numbersCount.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");

            System.out.printf("%s -> %d%n", df.format(number.getKey()), number.getValue());
        }

    }
}
