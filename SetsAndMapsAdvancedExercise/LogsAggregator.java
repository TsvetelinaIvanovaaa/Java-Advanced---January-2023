package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LogsAggregator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, Integer>> logsByUsers = new TreeMap<>();
        Map<String, Integer> durationsByUsers = new TreeMap<>();

        while (--n >= 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            logsByUsers.putIfAbsent(user, new TreeMap<>());

            if (logsByUsers.get(user).containsKey(ip)) {
                logsByUsers.get(user).put(ip, logsByUsers.get(user).get(ip) + duration);
            } else {
                logsByUsers.get(user).put(ip, duration);
            }
            if (durationsByUsers.containsKey(user)) {
                durationsByUsers.put(user, durationsByUsers.get(user) + duration);
            } else {
                durationsByUsers.put(user, duration);
            }
        }

        for (Map.Entry<String, Integer> e : durationsByUsers.entrySet()) {
            System.out.printf("%s: %d [", e.getKey(), e.getValue());

            AtomicInteger size = new AtomicInteger(logsByUsers.get(e.getKey()).size());
            logsByUsers.get(e.getKey()).forEach((key, value) -> {
                if (size.get() > 1) {
                    System.out.print(key + ", ");
                    size.getAndDecrement();
                } else {
                    System.out.print(key);
                }
            });
            System.out.println("]");
        }
    }
}