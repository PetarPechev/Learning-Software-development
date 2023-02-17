package Lab;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> names = new ArrayDeque<>(List.of(input));
        int toss = Integer.parseInt(scanner.nextLine());
        int cycle = 0;

        while (names.size() > 1) {
            for (int i = 1; i < toss; i++) {
                String currentChild = names.poll();
                names.offer(currentChild);
            }
            cycle++;
            boolean isPrimeCycle = isPrime(cycle);

            if (isPrimeCycle){
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
        }

        if (!names.isEmpty()) {
            System.out.println("Last is " + names.poll());
        }
    }

    private static boolean isPrime(int cycle) {

        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if ((cycle % i) == 0)
                return false;
        }
        return true;
    }
}
