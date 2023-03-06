package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingCars = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
                parkingCars.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingCars.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parkingCars.isEmpty()){
            System.out.print("Parking Lot is Empty");
        } else {
            parkingCars.forEach(System.out::println);
        }
    }
}
