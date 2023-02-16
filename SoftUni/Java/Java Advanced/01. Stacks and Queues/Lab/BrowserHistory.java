package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!browserHistory.isEmpty()) {
                    browserHistory.pop();
                }
            } else {
                browserHistory.push(input);
            }

            if (browserHistory.isEmpty()) {
                System.out.println("no previous URLs");
            } else {
                System.out.println(browserHistory.peek());
            }

            input = scanner.nextLine();
        }
    }
}
