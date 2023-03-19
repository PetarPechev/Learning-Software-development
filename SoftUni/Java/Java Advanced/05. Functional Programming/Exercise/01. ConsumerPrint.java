package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] consumers = scanner.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.println(name);

        Arrays.stream(consumers).forEach(printName);
    }
}
