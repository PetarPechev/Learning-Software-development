package JavaCore3;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LongestBlockInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] inputToCharArray = scanner.nextLine().toCharArray();

        int biggestCount = 1;
        int currentBiggestCount = 1;
        char charSymbol = inputToCharArray[0];

        for (int i = 1; i < inputToCharArray.length; i++) {
            if (inputToCharArray[i] == inputToCharArray[i-1]) {
                currentBiggestCount++;
            } else {
                currentBiggestCount = 1;
            }
            if (currentBiggestCount > biggestCount) {
                biggestCount = currentBiggestCount;
                charSymbol = inputToCharArray[i];
            }
        }

        printBiggestCountChar(biggestCount, charSymbol);

        inputToCharArray.toString().replaceAll("[\\[\\], ]", "");
    }

    private static void printBiggestCountChar(int biggestCount, char charSymbol) {
       /* for (int i = 0; i < biggestCount; i++) {
            System.out.print(charSymbol);
        }*/



        System.out.print(Collections.nCopies(biggestCount, charSymbol).toString().replaceAll("[\\[\\], ]", ""));
    }
}