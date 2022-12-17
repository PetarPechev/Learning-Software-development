package Exercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int pieces = length * width;
        boolean havePiecesLeft = true;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int takenPieces = Integer.parseInt(input);
            pieces -= takenPieces;

            if (pieces <= 0) {
                havePiecesLeft = false;
                break;
            }

            input = scanner.nextLine();
        }

        if (havePiecesLeft) {
            System.out.printf("%d pieces are left.", Math.abs(pieces));
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));
        }
    }
}
