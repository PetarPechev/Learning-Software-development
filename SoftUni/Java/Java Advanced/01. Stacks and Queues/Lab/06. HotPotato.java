package Lab;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> names = new ArrayDeque<>(List.of(input));
        int toss = Integer.parseInt(scanner.nextLine());

        while (names.size() > 1) {
            for (int i = 1; i < toss; i++) {
                names.offer(names.pop());
            }

            System.out.println("Removed " + names.pop());
        }

        if (!names.isEmpty()) {
            System.out.println("Last is " + names.pop());
        }
    }
}
