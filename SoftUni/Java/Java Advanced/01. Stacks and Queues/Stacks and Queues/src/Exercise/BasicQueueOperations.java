package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToAdd = input[0];
        int elementsToPoll = input[1];
        int containedElement = input[2];

        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 0; i < elementsToAdd; i++) {
            elements.offer(scanner.nextInt());
        }

        for (int i = 0; i < elementsToPoll; i++) {
            elements.poll();
        }

        if (elements.isEmpty()) {
            System.out.print(0);
        } else if (elements.contains(containedElement)) {
            System.out.print("true");
        } else {
            System.out.print(Collections.min(elements));
        }
    }
}
