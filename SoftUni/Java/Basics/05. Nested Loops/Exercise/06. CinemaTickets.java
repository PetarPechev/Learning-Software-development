package Exercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalTicketsSold = 0;
        int studentTicketsSold = 0;
        int standardTicketsSold = 0;
        int kidsTicketsSold = 0;
        String movieName = scanner.nextLine();

        while (!movieName.equals("Finish")) {
            int ticketsFourCurrentProjection = Integer.parseInt(scanner.nextLine());
            int soldTicketsForCurrentProjection = 0;

            while (soldTicketsForCurrentProjection < ticketsFourCurrentProjection) {
                String ticketType = scanner.nextLine();

                if (ticketType.equals("End") || ticketType.equals("Finish")) {
                    break;
                }

                soldTicketsForCurrentProjection++;

                switch (ticketType) {
                    case "student":
                        studentTicketsSold++;
                        break;
                    case "standard":
                        standardTicketsSold++;
                        break;
                    case "kid":
                        kidsTicketsSold++;
                        break;
                }
            }

            totalTicketsSold += soldTicketsForCurrentProjection;
            double percentageOfSoldTickets =
                    (1.0 * soldTicketsForCurrentProjection / ticketsFourCurrentProjection) * 100;

            System.out.printf("%s - %.2f%% full.%n", movieName, percentageOfSoldTickets);

            movieName = scanner.nextLine();
        }

        double percentageOfSoldStudentTickets =
                (1.0 * studentTicketsSold / totalTicketsSold) * 100;
        double percentageOfSoldStandardTickets =
                (1.0 * standardTicketsSold / totalTicketsSold) * 100;
        double percentageOfSoldKidsTickets =
                (1.0 * kidsTicketsSold / totalTicketsSold) * 100;

        System.out.printf("Total tickets: %d%n", totalTicketsSold);
        System.out.printf("%.2f%% student tickets.%n", percentageOfSoldStudentTickets);
        System.out.printf("%.2f%% standard tickets.%n", percentageOfSoldStandardTickets);
        System.out.printf("%.2f%% kids tickets.%n", percentageOfSoldKidsTickets);
    }
}
