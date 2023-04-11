package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            if(firstPlayer.isEmpty()){
                System.out.println("Second player win!");
                return;
            }

            if(secondPlayer.isEmpty()){
                System.out.println("First player win!");
                return;
            }

            int firstPlayerTopCard = firstPlayer.iterator().next();
            int secondPlayerTopCard = secondPlayer.iterator().next();

            firstPlayer.remove(firstPlayerTopCard);
            secondPlayer.remove(secondPlayerTopCard);

            if(firstPlayerTopCard > secondPlayerTopCard){
                firstPlayer.add(firstPlayerTopCard);
                firstPlayer.add(secondPlayerTopCard);
            }else if(secondPlayerTopCard > firstPlayerTopCard){
                secondPlayer.add(firstPlayerTopCard);
                secondPlayer.add(secondPlayerTopCard);
            }
        }
        int firstPlayerDeckSize = firstPlayer.size();
        int secondPlayerDeckSize = secondPlayer.size();

        if(firstPlayerDeckSize > secondPlayerDeckSize){
            System.out.println("First player win!");
        }else if(secondPlayerDeckSize > firstPlayerDeckSize){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
