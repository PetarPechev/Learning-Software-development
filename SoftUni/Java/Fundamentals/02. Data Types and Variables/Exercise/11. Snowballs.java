package Exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double biggestSnowBallValue = Double.MIN_VALUE;
        String outputBiggestSnowball = "";

        for (int i = 0; i < numberOfSnowballs; i++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());

            double currentSnowBallValue = Math.pow(((double)snowBallSnow / snowBallTime), snowBallQuality);

            if (currentSnowBallValue > biggestSnowBallValue){
                outputBiggestSnowball = String.format("%d : %d = %.0f (%d)",
                        snowBallSnow, snowBallTime, currentSnowBallValue, snowBallQuality);

                biggestSnowBallValue = currentSnowBallValue;
            }
        }

        System.out.println(outputBiggestSnowball);
    }
}
