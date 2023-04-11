package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> usersData = new TreeMap<>();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] tokens = inputLine.split("\\s+"); //["IP=192.23.30.40", "message='Hello&derps.'", "user=destroyer"]
            String ip = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String user = tokens[2].split("=")[1];

            if(!usersData.containsKey(user)){
                usersData.put(user, new LinkedHashMap<>(){{
                    put(ip, 1);
                }});
            }else{
                if(!usersData.get(user).containsKey(ip)){
                    usersData.get(user).put(ip, 1);
                }else{
                    int currentCountMessage = usersData.get(user).get(ip);
                    usersData.get(user).put(ip, currentCountMessage + 1);
                }
            }
            inputLine = scanner.nextLine();
        }
        for (String temp : usersData.keySet()) {
            System.out.printf("%s:%n",temp);
            int countEntries = 0;
            for (String entry : usersData.get(temp).keySet()) {
                countEntries++;
                if (countEntries < usersData.get(temp).size()) {
                    System.out.printf("%s => %d, ", entry, usersData.get(temp).get(entry));
                } else {
                    System.out.printf("%s => %d.%n", entry, usersData.get(temp).get(entry));
                }
            }
        }
    }
}
