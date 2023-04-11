package JavaAdvancedExamPreparation;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double[] milkQuantity = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double :: parseDouble).toArray();
        double[] cacaoPowderQuantity = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double :: parseDouble).toArray();

        ArrayDeque<Double> milkQuantityQueue = new ArrayDeque<>();
        Arrays.stream(milkQuantity).forEach(milkQuantityQueue::offer);
        ArrayDeque<Double> cacaoPowderQuantityStack = new ArrayDeque<>();
        Arrays.stream(cacaoPowderQuantity).forEach(cacaoPowderQuantityStack::push);

        Map<Double, String> chocolateTypes = new HashMap<>();
        chocolateTypes.put(30.0, "Milk Chocolate");
        chocolateTypes.put(50.0, "Dark Chocolate");
        chocolateTypes.put(100.0, "Baking Chocolate");

        Map<String, Integer> preparedChocolates = new TreeMap<>();

        boolean isMilkChocolateMade = false;
        boolean isDarkChocolateMade = false;
        boolean isBakingChocolateMade = false;
        while(!milkQuantityQueue.isEmpty() && !cacaoPowderQuantityStack.isEmpty()){
            double currentMilkQuantity = milkQuantityQueue.peek();
            double currentCacaoPowderQuantity = cacaoPowderQuantityStack.peek();
            double cacaoPercentage = (currentCacaoPowderQuantity / (currentCacaoPowderQuantity + currentMilkQuantity))*100;

            cacaoPowderQuantityStack.pop();

            if(chocolateTypes.containsKey(cacaoPercentage)){
                String currentItem = chocolateTypes.get(cacaoPercentage);
                if(currentItem == "Milk Chocolate"){
                    isMilkChocolateMade = true;
                }else if(currentItem == "Dark Chocolate"){
                    isDarkChocolateMade = true;
                }else if(currentItem == "Baking Chocolate"){
                    isBakingChocolateMade = true;
                }
                preparedChocolates.putIfAbsent(currentItem, 0);
                int currentValue = preparedChocolates.get(currentItem);
                preparedChocolates.put(currentItem, currentValue + 1);

                milkQuantityQueue.poll();

            }else{
                currentMilkQuantity = milkQuantityQueue.poll() + 10;
                milkQuantityQueue.offer(currentMilkQuantity);
            }
        }
        if(isMilkChocolateMade && isDarkChocolateMade && isBakingChocolateMade){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            preparedChocolates.entrySet().stream().forEach(entry ->
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            preparedChocolates.entrySet().stream().forEach(entry ->
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));
        }
    }
}
