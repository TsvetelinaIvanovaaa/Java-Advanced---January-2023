package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<Character, Integer> sequence = new TreeMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            if(!sequence.containsKey(currentSymbol)){
                sequence.put(currentSymbol, 1);
            }else{
                int currentCount = sequence.get(currentSymbol);
                sequence.put(currentSymbol, currentCount + 1);
            }
        }
        for (char symbol : sequence.keySet()) {
            System.out.printf("%c: %d time/s%n", symbol, sequence.get(symbol));
        }
    }
}
