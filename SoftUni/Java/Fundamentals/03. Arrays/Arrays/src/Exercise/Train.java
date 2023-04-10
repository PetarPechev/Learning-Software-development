package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfWagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[countOfWagons];

        for (int i = 0; i < countOfWagons; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int wagon : train) {
            System.out.print(wagon + " ");
        }

        int sum = Arrays.stream(train).sum();

        System.out.println();
        System.out.print(sum);
    }
}
