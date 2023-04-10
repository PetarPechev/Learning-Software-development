package Lab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Integer.parseInt(scanner.nextLine());
        double height = Integer.parseInt(scanner.nextLine());

        double area = calculateRectangleArea(width, height);

        System.out.printf("%.0f", area);
    }

    private static double calculateRectangleArea(double width, double height) {
        return width * height;
    }
}
