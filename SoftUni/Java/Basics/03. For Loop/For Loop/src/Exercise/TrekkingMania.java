package Exercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTeams = Integer.parseInt(scanner.nextLine());
        int musalaAlpinistsCount = 0;
        int montBlancAlpinistsCount = 0;
        int kilimanjaroAlpinistsCount = 0;
        int k2AlpinistsCount = 0;
        int everestAlpinistsCount = 0;
        int sum = 0;

        for (int i = 0; i < countOfTeams; i++) {
            int alpinists = Integer.parseInt(scanner.nextLine());
            sum += alpinists;

            if (alpinists <= 5) {
                musalaAlpinistsCount += alpinists;
            } else if (alpinists >= 6 && alpinists <= 12) {
                montBlancAlpinistsCount += alpinists;
            } else if (alpinists >= 13 && alpinists <= 25) {
                kilimanjaroAlpinistsCount += alpinists;
            } else if (alpinists >= 26 && alpinists <= 40) {
                k2AlpinistsCount += alpinists;
            } else if (alpinists >= 41) {
                everestAlpinistsCount += alpinists;
            }
        }

        System.out.printf("%.2f%%%n", (1.0 * musalaAlpinistsCount / sum) * 100);
        System.out.printf("%.2f%%%n", (1.0 * montBlancAlpinistsCount / sum) * 100);
        System.out.printf("%.2f%%%n", (1.0 * kilimanjaroAlpinistsCount / sum) * 100);
        System.out.printf("%.2f%%%n", (1.0 * k2AlpinistsCount / sum) * 100);
        System.out.printf("%.2f%%%n", (1.0 * everestAlpinistsCount / sum) * 100);
    }
}
