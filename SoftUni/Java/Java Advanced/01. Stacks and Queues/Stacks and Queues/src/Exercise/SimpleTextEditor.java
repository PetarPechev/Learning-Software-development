package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operationsCount = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> textHistory = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int typeOfCommand = Integer.parseInt(input[0]);;

            if (typeOfCommand == 1){
                textHistory.push(text.toString());
                String textToAppend = input[1];
                text.append(textToAppend);
            } else if (typeOfCommand == 2) {
                textHistory.push(text.toString());
                int countOfElementsToBeDeleted = Integer.parseInt(input[1]);
                text.delete(text.length() - countOfElementsToBeDeleted, text.length());
            } else if (typeOfCommand == 3) {
                int index = Integer.parseInt(input[1]) - 1;
                System.out.println(text.charAt(index));
            } else if (typeOfCommand == 4 && !textHistory.isEmpty()) {
                text = new StringBuilder(textHistory.pop());
            }
        }
    }
}
