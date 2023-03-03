package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterial = new LinkedHashMap<>();
        insertKeyMaterials(keyMaterial);
        Map<String, Integer> junkMaterial = new LinkedHashMap<>();
        boolean haveWinner = false;

        while (!haveWinner) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int index = 0; index < input.length; index+= 2) {
                int quantity = Integer.parseInt(input[index]);
                String item = input[index + 1].toLowerCase();

                if (keyMaterial.containsKey(item)){
                    keyMaterial.put(item, keyMaterial.get(item) + quantity);

                    if (keyMaterial.get(item) >= 250){
                        getKeyItem(item, keyMaterial);
                        haveWinner = true;
                        break;
                    }
                } else {
                    junkMaterial.putIfAbsent(item, 0);
                    junkMaterial.put(item, junkMaterial.get(item) + quantity);
                }
            }
        }

        keyMaterial.forEach((key, value) -> System.out.println(key + ": " + value));
        junkMaterial.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void insertKeyMaterials(Map<String, Integer> keyMaterial) {
        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);
    }

    private static void getKeyItem(String item, Map<String, Integer> keyMaterial) {
        String keyItem = "";

        switch (item) {
            case "shards":
                keyItem = "Shadowmourne";
                break;
            case "fragments":
                keyItem = "Valanyr";
                break;
            case "motes":
                keyItem = "Dragonwrath";
                break;
        }

        keyMaterial.put(item, Math.abs(keyMaterial.get(item) - 250));
        System.out.println(keyItem + " obtained!");
    }
}
