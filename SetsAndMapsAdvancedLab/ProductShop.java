package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Map<String, Map<String, Double>> shopsInfo = new TreeMap<>();

        while (!inputLine.equals("Revision")) {
            String[] tokens = inputLine.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!shopsInfo.containsKey(shop)) {
                shopsInfo.put(shop, new LinkedHashMap<>());
                shopsInfo.get(shop).put(product, price);
            } else {
                shopsInfo.get(shop).put(product, price);
            }

            inputLine = scanner.nextLine();
        }
        //for (Integer temp : map.keySet()) {
        //for (Character c : map.get(temp).keySet()) {
        //    System.out.println("key--" + c + "--value--" + map.get(temp).get(c));
        for (String entry : shopsInfo.keySet()) {
            System.out.printf("%s->%n", entry);
            for (String temp : shopsInfo.get(entry).keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", temp, shopsInfo.get(entry).get(temp));
            }
        }
    }
}
