package Exercise;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursBefore = Integer.parseInt(scanner.nextLine());
        int minutesBefore = Integer.parseInt(scanner.nextLine());
        int totalMinutes = hoursBefore * 60 + minutesBefore + 15;
        int hoursAfter = totalMinutes / 60;
        int minutesAfter = totalMinutes % 60;

        if (hoursAfter >= 24) {
            hoursAfter %= 24;
        }

        System.out.printf("%d:%02d", hoursAfter, minutesAfter);
    }
}
