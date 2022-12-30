package Exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int result = addAndSubtract(firstNum, secondNum, thirdNum);

        System.out.print(result);
    }

    private static int addAndSubtract(int firstNum, int secondNum, int thirdNum) {
        return (firstNum + secondNum) - thirdNum;
    }
}
