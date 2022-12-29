package Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String valueType = scanner.nextLine().toLowerCase();

        switch (valueType) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                getMax(firstNum, secondNum);
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                getMax(firstChar, secondChar);
                break;
            case "string":
                String firstText = scanner.nextLine();
                String secondText = scanner.nextLine();
                getMax(firstText, secondText);
                break;
        }
    }

    private static void getMax(String firstText, String secondText) {
        if (firstText.compareTo(secondText) == 1) {
            System.out.print(firstText);
        } else {
            System.out.print(secondText);
        }
    }

    private static void getMax(char firstChar, char secondChar) {
        char biggestChar = (char)Math.max(firstChar, secondChar);
        System.out.print(biggestChar);
    }

    private static void getMax(int firstNum, int secondNum) {
        int maxNumber = Math.max(firstNum, secondNum);

        System.out.print(maxNumber);
    }
}
