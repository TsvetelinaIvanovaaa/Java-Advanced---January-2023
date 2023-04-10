package JavaAdvancedExamPreparation;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> portionStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();

        int[] portionArray = Arrays.stream(scanner.nextLine()
                .split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] staminaArray = Arrays.stream(scanner.nextLine()
                .split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < portionArray.length; i++) {
            portionStack.push(portionArray[i]);
        }
        for (int i = 0; i < staminaArray.length; i++) {
            staminaQueue.offer(staminaArray[i]);
        }

        ArrayDeque<String> conqueredPeaks = new ArrayDeque<>();

        ArrayDeque<String> mountainPeaks = new ArrayDeque<>();
        ArrayDeque<Integer> difficultyLevel = new ArrayDeque<>();
        String peaks = "Vihren, Kutelo, Banski Suhodol, Polezhan, Kamenitza";
        Arrays.stream(peaks.split(", ")).forEach(mountainPeaks::offer);
        String difficult = "80, 90, 100, 60, 70";
        Arrays.stream(difficult.split(", ")).map(Integer::parseInt).forEach(difficultyLevel::offer);

        int days = 7;
        int sum = 0;
        while (days-->0){
            if(!difficultyLevel.isEmpty() && !portionStack.isEmpty() && !staminaQueue.isEmpty()){
                sum = portionStack.peek() + staminaQueue.peek();
                if(sum >= difficultyLevel.peek()){
                    difficultyLevel.poll();
                    conqueredPeaks.offer(mountainPeaks.poll());
                }
                portionStack.pop();
                staminaQueue.poll();
            }
        }
        if(difficultyLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(!conqueredPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
        }
        while (!conqueredPeaks.isEmpty()){
            System.out.println(conqueredPeaks.poll());
        }

    }
}
