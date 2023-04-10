package Exercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int totalSpace = width * length * height;
        boolean haveSpace = true;

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int boxesCount = Integer.parseInt(input);
            totalSpace -= boxesCount;

            if (totalSpace <= 0){
                haveSpace = false;
                break;
            }

            input = scanner.nextLine();
        }

        if (haveSpace){
            System.out.printf("%d Cubic meters left.", Math.abs(totalSpace));
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalSpace));
        }
    }
}
