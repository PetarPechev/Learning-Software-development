package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            int firstPlayerCard = firstDeck.get(0);
            int secondPlayerCard = secondDeck.get(0);

            if (firstPlayerCard == secondPlayerCard) {
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else if (firstPlayerCard > secondPlayerCard) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                firstDeck.add(firstPlayerCard);
                firstDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                secondDeck.add(secondPlayerCard);
                secondDeck.add(firstPlayerCard);
            }
        }

        if (firstDeck.size() > secondDeck.size()) {
            System.out.print("First player wins! Sum: " + calculateSumOfCards(firstDeck));
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.print("Second player wins! Sum: " + calculateSumOfCards(secondDeck));
        }
    }

    private static int calculateSumOfCards(List<Integer> deck) {

        return deck.stream().mapToInt(Integer::intValue).sum();
    }
}
