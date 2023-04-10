package Exercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int gpuCardAmount = Integer.parseInt(scanner.nextLine());
        int cpuAmount = Integer.parseInt(scanner.nextLine());
        int ramAmount = Integer.parseInt(scanner.nextLine());

        double gpuPrice = 250.0;
        double totalPriceForGpu = gpuPrice * gpuCardAmount;
        double cpuPrice = totalPriceForGpu * 0.35;
        double ramPrice = totalPriceForGpu * 0.1;

        double totalPrice = totalPriceForGpu + cpuPrice * cpuAmount + ramPrice * ramAmount;

        if (gpuCardAmount > cpuAmount){
            totalPrice -= totalPrice * 0.15;
        }

        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
        }
    }
}
