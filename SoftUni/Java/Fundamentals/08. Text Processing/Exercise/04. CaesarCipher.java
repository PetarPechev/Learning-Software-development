package Exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] cipher = text.toCharArray();

        for (int i = 0; i < cipher.length; i++) {
            cipher[i] = (char)(cipher[i] + 3);
        }

        String cipheredText = new String(cipher);

        System.out.print(cipheredText);
    }
}
