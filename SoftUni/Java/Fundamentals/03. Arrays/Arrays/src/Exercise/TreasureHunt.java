package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");
        String[] command = scanner.nextLine().split("\\s+");

        while (!command[0].equals("Yohoho!")) {

            if (command[0].equals("Loot")) {
                for (int i = 1; i < command.length; i++) {
                    boolean alreadyContained = false;

                    for (int j = 0; j < treasureChest.length; j++) {
                        if (command[i].equals(treasureChest[j])) {
                            alreadyContained = true;
                            break;
                        }
                    }

                    if (!alreadyContained) {
                        String newChest = command[i] + " " + String.join(" ", treasureChest);
                        treasureChest = newChest.split(" ");
                    }
                }
            } else if (command[0].equals("Drop")) {
                int position = Integer.parseInt(command[1]);

                if (position <= treasureChest.length - 1 && position >= 0) {
                    String dropItem = treasureChest[position];

                    for (int i = position; i < treasureChest.length - 1; i++) {
                        treasureChest[i] = treasureChest[i + 1];
                    }

                    treasureChest[treasureChest.length - 1] = dropItem;
                }
            } else if (command[0].equals("Steal")) {
                int numberOfStealingItems = Integer.parseInt(command[1]);

                if (numberOfStealingItems >= 0 && numberOfStealingItems < treasureChest.length) {
                    for (int i = 0; i < numberOfStealingItems; i++) {
                        System.out.print(treasureChest[treasureChest.length - numberOfStealingItems + i]);
                        if (i != numberOfStealingItems - 1) {
                            System.out.print(", ");
                        }
                    }
                    String[] tempChest = new String[treasureChest.length - numberOfStealingItems];
                    for (int i = 0; i < tempChest.length; i++) {
                        tempChest[i] = treasureChest[i];
                    }
                    treasureChest = tempChest;

                } else if (numberOfStealingItems >= 0) {
                    for (int i = 0; i < treasureChest.length; i++) {
                        System.out.print(treasureChest[i]);
                        if (i != treasureChest.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    treasureChest = new String[0];
                }
                System.out.println();
            }

            command = scanner.nextLine().split("\\s+");
        }

        String treasureCount = String.join("", treasureChest);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }

        double averageTreasure = (1.0 * charCounter) / treasureChest.length;

        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
