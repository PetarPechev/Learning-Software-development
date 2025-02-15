package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "^(?<singer>([A-Za-z]+\\s){1,3})@(?<venue>([A-Za-z]+\\s){1,3})(?<ticketsPrice>\\d+)\\s(?<ticketsCount>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Map<String, LinkedHashMap<String, Integer>> singersByVenue = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer").trim();
                String venue = matcher.group("venue").trim();

                Integer ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                Integer ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int totalMoney = ticketsCount * ticketsPrice;

                singersByVenue.putIfAbsent(venue, new LinkedHashMap<>());
                singersByVenue.get(venue).putIfAbsent(singer, 0);

                singersByVenue.get(venue).put(singer, singersByVenue.get(venue).get(singer) + totalMoney);
            }

            input = scanner.nextLine();
        }

        printSingersByVenue(singersByVenue);
    }

    private static void printSingersByVenue(Map<String, LinkedHashMap<String, Integer>> singersByVenue) {
        singersByVenue.forEach((venue, singerMoney) -> {
            System.out.println(venue);

            singerMoney.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                    .reversed()).forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));

        });

//        for (var venue : singersByVenue.entrySet()) {
//            System.out.println(venue.getKey());
//
//            venue.getValue().entrySet().stream()
//                    .sorted(Map.Entry.<String, Integer>comparingByValue()
//                            .reversed())
//                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
//
//        }
    }
}
