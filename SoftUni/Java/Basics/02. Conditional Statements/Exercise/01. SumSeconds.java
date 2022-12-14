package Exercise;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTime = Integer.parseInt(scanner.nextLine());
        int secondTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());
        int sum = firstTime + secondTime + thirdTime;

        int minutes = sum / 60;
        int seconds = sum % 60;

        System.out.printf("%d:%02d", minutes, seconds);
    }
}
