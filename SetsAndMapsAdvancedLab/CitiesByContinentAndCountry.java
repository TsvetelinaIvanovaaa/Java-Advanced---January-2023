package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String inputData = scanner.nextLine();
            String[] tokens = inputData.split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if(!data.containsKey(continent)){
                data.put(continent, new LinkedHashMap<>());
                data.get(continent).put(country, new ArrayList<>());
                data.get(continent).get(country).add(city);
            }else {
                if (!data.get(continent).containsKey(country)) {
                    data.get(continent).put(country, new ArrayList<>());
                    data.get(continent).get(country).add(city);
                } else {
                    if (!data.get(continent).get(country).contains(city)) {
                        data.get(continent).get(country).add(city);
                    }else{
                        data.get(continent).get(country).add(city);
                    }
                }
            }
        }
        for (String temp : data.keySet()) {
            System.out.printf("%s:%n",temp);
            for (String entry : data.get(temp).keySet()) {
                System.out.printf("%s -> %s%n",entry, String.join(", ",data.get(temp).get(entry)));
            }
        }
    }
}
