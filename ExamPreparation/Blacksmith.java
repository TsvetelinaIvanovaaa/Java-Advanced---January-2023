package JavaAdvancedExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] steel = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt).toArray();
        int[] carbon = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt).toArray();

        ArrayDeque<Integer> steelAsQueue = new ArrayDeque<>();
        Arrays.stream(steel).forEach(steelAsQueue::offer);
        ArrayDeque<Integer> carbonAsStack = new ArrayDeque<>();
        Arrays.stream(carbon).forEach(carbonAsStack::push);

        Map<Integer, String> sword = new HashMap<>();
        sword.put(70, "Gladius");
        sword.put(80, "Shamshir");
        sword.put(90, "Katana");
        sword.put(110, "Sabre");

        Map<String, Integer> forgedSword = new TreeMap<>();

        int swordsCount = 0;
        while (!steelAsQueue.isEmpty() && !carbonAsStack.isEmpty()){
            int sum = steelAsQueue.peek() + carbonAsStack.peek();
            steelAsQueue.poll();
            if(sword.containsKey(sum)){
                String currentItem = sword.get(sum);
                forgedSword.putIfAbsent(currentItem, 0);
                int currentValue = forgedSword.get(currentItem);
                forgedSword.put(currentItem, currentValue + 1);
                swordsCount++;

                carbonAsStack.pop();
            }else{
                int currentCarbon = carbonAsStack.pop() + 5;
                carbonAsStack.push(currentCarbon);
            }
        }
        if(swordsCount > 0){
            System.out.printf("You have forged %d swords.%n", swordsCount);
            if(steelAsQueue.isEmpty()){
                System.out.println("Steel left: none");
            }else{
                System.out.print("Steel left: ");
                System.out.println(steelAsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            if(carbonAsStack.isEmpty()){
                System.out.println("Carbon left: none");
            }else{
                System.out.print("Carbon left: ");
                System.out.println(carbonAsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            forgedSword.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ":" + " " + entry.getValue()));
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
            if(steelAsQueue.isEmpty()){
                System.out.println("Steel left: none");
            }else{
                System.out.print("Steel left: ");
                System.out.println(steelAsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            if(carbonAsStack.isEmpty()){
                System.out.println("Carbon left: none");
            }else{
                System.out.print("Carbon left: ");
                System.out.println(carbonAsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            forgedSword.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ":" + " " + entry.getValue()));
        }
    }
}
