package MockExam4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstArr = Arrays
                .stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondArr = Arrays
                .stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] result = new int[firstArr.size()];

        for (int i = 0; i < firstArr.size(); i++) {
            boolean isGreater = false;
            int startIndex = secondArr.indexOf(firstArr.get(i));

            if (startIndex >= 0 && startIndex < secondArr.size()) {
                for (int j = startIndex; j < secondArr.size(); j++) {
                    if (firstArr.get(i) < secondArr.get(j)) {
                        result[i] = secondArr.get(j);
                        isGreater = true;
                        break;
                    }
                }
            }

            if (!isGreater) {
                result[i] = -1;
            }
        }

        System.out.print(Arrays.toString(result).replaceAll("[\\[\\] ]", ""));
    }
}
