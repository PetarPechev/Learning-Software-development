package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = addElements(firstList, secondList);

        System.out.print(result.toString().replaceAll("[\\[\\],]", ""));

    }

    private static List<Integer> addElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        int minSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minSize; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }

        if (firstList.size() > secondList.size()) {
            result.addAll(firstList.subList(minSize, firstList.size()));
        } else {
            result.addAll(secondList.subList(minSize, secondList.size()));
        }

        return result;
    }
}
