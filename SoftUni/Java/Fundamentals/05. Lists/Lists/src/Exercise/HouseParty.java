package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String guestName = input[0];
            boolean isGoing = input[2].equals("going!");

            if (isGoing) {
                names = addGuest(names, guestName);
            } else {
                names = removeGuest(names, guestName);
            }
        }

        printGuestNames(names);
    }

    private static void printGuestNames(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<String> removeGuest(List<String> names, String guestName) {
        if (!names.contains(guestName)) {
            System.out.println(guestName + " is not in the list!");
        } else {
            names.remove(guestName);
        }

        return names;
    }

    private static List<String> addGuest(List<String> names, String guestName) {
        if (names.contains(guestName)) {
            System.out.println(guestName + " is already in the list!");
        } else {
            names.add(guestName);
        }

        return names;
    }
}
