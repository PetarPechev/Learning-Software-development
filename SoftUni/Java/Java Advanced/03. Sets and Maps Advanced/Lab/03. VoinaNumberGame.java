package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            if (firstDeck.isEmpty() || secondDeck.isEmpty()){
                break;
            }

            int firstDeckCard = firstDeck.iterator().next();
            int secondDeckCard = secondDeck.iterator().next();
            firstDeck.remove(firstDeckCard);
            secondDeck.remove(secondDeckCard);

            if (firstDeckCard > secondDeckCard) {
                firstDeck.add(firstDeckCard);
                firstDeck.add(secondDeckCard);
            } else if (secondDeckCard < firstDeckCard) {
                secondDeck.add(firstDeckCard);
                secondDeck.add(secondDeckCard);
            }
        }

        printWinner(firstDeck, secondDeck);
        
    }

    private static void printWinner(Set<Integer> firstDeck, Set<Integer> secondDeck) {
        if (firstDeck.size() > secondDeck.size()) {
            System.out.print("First player win!");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.print("Second player win!");
        } else {
            System.out.print("Draw");
        }
    }
}
