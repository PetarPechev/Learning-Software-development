package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(browserHistory.pop());
                    System.out.println(browserHistory.peek());
                }
            } else if (input.equals("forward")) {
                if (!forwardHistory.isEmpty()) {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.poll());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                browserHistory.push(input);
                forwardHistory.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
