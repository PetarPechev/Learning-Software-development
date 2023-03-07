package Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfCountries = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> continentsData = new LinkedHashMap<>();

        for (int i = 0; i < countOfCountries; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentsData.putIfAbsent(continent, new LinkedHashMap<>());
            continentsData.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsData.get(continent).get(country).add(city);
        }

        printContinentsData(continentsData);
    }

    private static void printContinentsData(Map<String, Map<String, List<String>>> continentsData) {
        continentsData.forEach((continent, countries) -> {
            System.out.println(continent + ":");

            countries.forEach((country, cities) -> {
                System.out.println(" " + country + " -> " + String.join(", ", cities));
            });
        });

//        for (Map.Entry<String, Map<String, List<String>>> continent : continentsData.entrySet()) {
//            System.out.println(continent.getKey() + ":");
//
//            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
//                System.out.println(" " + country.getKey() + " -> " + String.join(", ", country.getValue()));
//            }
//        }
    }
}
