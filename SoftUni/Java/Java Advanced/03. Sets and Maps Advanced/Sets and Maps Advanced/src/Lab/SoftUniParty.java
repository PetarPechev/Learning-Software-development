package Lab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String reservationNumber = "";

        while (!(reservationNumber = scanner.nextLine()).equals("PARTY")) {
            if (Character.isDigit(reservationNumber.charAt(0))) {
                vip.add(reservationNumber);
            } else {
                regular.add(reservationNumber);
            }
        }

        while (!(reservationNumber = scanner.nextLine()).equals("END")) {
            if (Character.isDigit(reservationNumber.charAt(0))) {
                vip.remove(reservationNumber);
            } else {
                regular.remove(reservationNumber);
            }
        }

        System.out.println(regular.size() + vip.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
