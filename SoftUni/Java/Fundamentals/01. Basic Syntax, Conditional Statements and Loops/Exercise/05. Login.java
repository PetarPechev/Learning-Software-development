package Exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder(username);
        password.reverse();

        String input = scanner.nextLine();
        int count = 1;

        while (!input.equals(password.toString())) {
            if (count == 4){
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
            count++;
        }

        if (input.equals(password.toString())) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
