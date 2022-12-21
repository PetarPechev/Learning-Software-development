package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        switch (country) {
            case "USA":
            case "England":
                System.out.print("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.print("Spanish");
                break;
            default:
                System.out.print("unknown");
                break;
        }
    }
}
