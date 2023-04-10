package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        Function<int[], int[]> add = Arrays.stream(numbers).map(n -> n + 1);

        while (!command.equals("end")) {



            command = scanner.nextLine();
        }
    }
}
