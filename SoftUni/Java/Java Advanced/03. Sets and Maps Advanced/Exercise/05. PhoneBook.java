package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        addContacts(phoneBook, scanner);
        searchForContact(phoneBook, scanner);
    }

    private static void searchForContact(Map<String, String> phoneBook, Scanner scanner) {
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            if (phoneBook.containsKey(name)){
                System.out.println(name + " -> " + phoneBook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            name = scanner.nextLine();
        }
    }

    private static void addContacts(Map<String, String> phoneBook, Scanner scanner) {
        String nameAndNumber = scanner.nextLine();

        while (!nameAndNumber.equals("search")) {
            String name = nameAndNumber.split("-")[0];
            String phoneNumber = nameAndNumber.split("-")[1];

            phoneBook.put(name, phoneNumber);

            nameAndNumber = scanner.nextLine();
        }
    }
}
