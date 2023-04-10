package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputTexts = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("3:1")) {
            String command = inputCommand.split("\\s+")[0];

            if (command.equals("merge")) {
                int startIndex = Math.max(Integer.parseInt(inputCommand.split("\\s+")[1]), 0);
                int endIndex = Math.max(Integer.parseInt(inputCommand.split("\\s+")[2]), inputTexts.size() - 1);

                for (int counter = startIndex; counter < endIndex; counter++) {
                    String mergedText = inputTexts.get(startIndex) + inputTexts.get(startIndex + 1);
                    inputTexts.set(startIndex, mergedText);
                    inputTexts.remove(startIndex + 1);
                }
            } else if (command.equals("divide")) {
                int index = Integer.parseInt(inputCommand.split("\\s+")[1]);
                int partitions = Integer.parseInt(inputCommand.split("\\s+")[2]);
            }

            inputCommand = scanner.nextLine();
        }

        System.out.println(String.join(" ", inputTexts));
    }
}
