package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            if (input.contains("Add")) {
                int wagonWithPassengers = Integer.parseInt(input.split("\\s+")[1]);
                wagons.add(wagonWithPassengers);
            } else {
                int passengersToAdd = Integer.parseInt(input);
                wagons = addPassengers(wagons, passengersToAdd, capacity);
            }

            input = scanner.nextLine();
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> addPassengers(List<Integer> wagons, int passengersToAdd, int capacity) {

        for (int i = 0; i < wagons.size() && passengersToAdd > 0; i++) {
            if (passengersToAdd + wagons.get(i) <= capacity) {
                wagons.set(i, wagons.get(i) + passengersToAdd);
                break;
            }
        }

        return wagons;
    }
}
