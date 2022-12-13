package Exercise;

import java.util.Scanner;

public class UsdToBgn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usd = Double.parseDouble(scanner.nextLine());
        double convertRateUsdToBgn = 1.79549;
        double usdToBgn = usd * convertRateUsdToBgn;

        System.out.println(usdToBgn);
    }
}
