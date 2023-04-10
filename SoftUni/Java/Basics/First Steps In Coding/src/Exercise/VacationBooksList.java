package Exercise;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesCountOnCurrentBook = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysToRead = Integer.parseInt(scanner.nextLine());
        int neededHoursPerDay = (pagesCountOnCurrentBook / pagesPerHour) / daysToRead;

        System.out.println(neededHoursPerDay);
    }
}
