package Lab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floorsCount = Integer.parseInt(scanner.nextLine());
        int roomsPerFloor = Integer.parseInt(scanner.nextLine());

        for (int floor = floorsCount; floor >= 1; floor--) {
            for (int number = 0; number < roomsPerFloor; number++) {
                if (floor == floorsCount) {
                    System.out.printf("L%d%d ", floor, number);
                } else if (floor % 2 == 0) {
                    System.out.printf("O%d%d ", floor, number);
                } else {
                    System.out.printf("A%d%d ", floor, number);
                }
            }
            System.out.println();
        }
    }
}
