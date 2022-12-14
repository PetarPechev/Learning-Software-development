package Lab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        double area = 0;

        if (type.equals("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            area = Math.pow(a, 2);
        } else if (type.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            area = a * b;
        } else if (type.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.pow(radius, 2) * Math.PI;
        } else if (type.equals("triangle")) {
            double base = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            area = (base * height) / 2;
        }

        System.out.printf("%.3f", area);
    }
}
