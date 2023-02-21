package EntryExamAlpha48;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class secondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nums = Arrays
                .stream(scanner.nextLine().split(","))
                .collect(Collectors.toList());

        int limitedTo = scanner.nextInt();
        boolean areSame = true;

        for (int i = 0; i < limitedTo; i++) {
            String leftSide = nums.get(i);
            String rightSide = nums.get(nums.size() - 1 - i);

            if (!leftSide.equals(rightSide)) {
                areSame = false;
                System.out.printf("false %s,%s", leftSide, rightSide);
                break;
            }
        }

        if (areSame) {
            System.out.println("true " + String.join(",", nums.subList(0, limitedTo)));
        }
    }
}
