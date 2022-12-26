package Lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int number = Integer.parseInt(scanner.nextLine());

        if (number >= 1 && number <= 7) {
            System.out.print(daysOfWeek[number-1]);
        } else {
            System.out.print("Invalid day!");
        }
    }
}
