package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, Set<String>> playersData = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String player = input.split(":\\s+")[0]; //[Peter]
            String cards = input.split(":\\s+")[1]; //[2C, 4H, 9H, AS, QS]

            String[] playerCards = cards.split(",\\s+");
            Set<String> handsOfCards = new HashSet<>();
            handsOfCards.addAll(Arrays.asList(playerCards));

            if (!playersData.containsKey(player)) {
                playersData.put(player, handsOfCards);
            } else {
                Set<String> currentHandsOfCards = playersData.get(player);
                currentHandsOfCards.addAll(handsOfCards);
                playersData.put(player, currentHandsOfCards);

                input = scanner.nextLine();
            }
        }
        playersData.entrySet().forEach(entry ->{
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n",name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> symbolsValues = getSymbolsValues();
        int sumPoints = 0;

        for (String card : cards) {
            int points = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);
                points = 10 * symbolsValues.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                points = symbolsValues.get(power) * symbolsValues.get(type);
            }
            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> charactersValues = new HashMap<>();
        charactersValues.put('2',2);
        charactersValues.put('3',3);
        charactersValues.put('4',4);
        charactersValues.put('5',5);
        charactersValues.put('6',6);
        charactersValues.put('7',7);
        charactersValues.put('8',8);
        charactersValues.put('9',9);
        charactersValues.put('J',11);
        charactersValues.put('Q',12);
        charactersValues.put('K',13);
        charactersValues.put('A',14);
        charactersValues.put('S',4);
        charactersValues.put('H',3);
        charactersValues.put('D',2);
        charactersValues.put('C',1);
        return charactersValues;
    }
}
