package Lab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char currentChar = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(currentChar)) {
            System.out.print("upper-case");
        } else if (Character.isLowerCase(currentChar)) {
            System.out.print("lower-case");
        }
    }
}
