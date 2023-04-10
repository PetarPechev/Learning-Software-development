package exam;

import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] playground = new char[n][m];
        int playerRow = 0;
        int playerCol = 0;
        int movesCount = 0;
        int touchedOpponents = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                playground[i][j] = scanner.next().charAt(0);
                if (playground[i][j] == 'B') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String command = scanner.next();
        while (!command.equals("Finish") && touchedOpponents < 3) {
            int newRow = playerRow;
            int newCol = playerCol;
            switch (command) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                char target = playground[newRow][newCol];
                if (target == '-') {
                    movesCount++;
                    playground[playerRow][playerCol] = '-';
                    playerRow = newRow;
                    playerCol = newCol;
                    playground[playerRow][playerCol] = 'B';
                } else if (target == 'P') {
                    touchedOpponents++;
                    movesCount++;
                    playground[playerRow][playerCol] = '-';
                    playerRow = newRow;
                    playerCol = newCol;
                    playground[playerRow][playerCol] = 'B';
                }
            }
            command = scanner.next();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", touchedOpponents, movesCount);

    }
}
