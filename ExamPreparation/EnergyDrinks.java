package JavaAdvancedExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] caffeineMilligrams = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer :: parseInt).toArray();
        int[] energyDrinks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer :: parseInt).toArray();

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(caffeineMilligrams).forEach(caffeineStack::push);
        ArrayDeque<Integer> drinksQueue = new ArrayDeque<>();
        Arrays.stream(energyDrinks).forEach(drinksQueue::offer);

        int maxCaffeine = 300;
        int currentDrinkCaffeine = 0;
        int currentStamatCaffeine = 0;
        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()){
            currentDrinkCaffeine = caffeineStack.peek() * drinksQueue.peek();
            if(currentDrinkCaffeine + currentStamatCaffeine <= maxCaffeine){
                caffeineStack.pop();
                drinksQueue.poll();
                currentStamatCaffeine += currentDrinkCaffeine;
            }else{
                caffeineStack.pop();
                int currentDrink = drinksQueue.poll();
                drinksQueue.offer(currentDrink);
                if(currentStamatCaffeine >= 30) {
                    currentStamatCaffeine -= 30;
                }
            }
        }
        if(!drinksQueue.isEmpty()){
            System.out.print("Drinks left: ");
            //System.out.println(textilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(drinksQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.printf("Stamat is going to sleep with %d mg caffeine.", currentStamatCaffeine);
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            System.out.printf("Stamat is going to sleep with %d mg caffeine.", currentStamatCaffeine);
        }
    }
}
