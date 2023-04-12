package RetakeExam;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] completeTime = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer :: parseInt).toArray();
        int[] taskCount = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer :: parseInt).toArray();

        ArrayDeque<Integer> competeTimeQueue = new ArrayDeque<>();
        Arrays.stream(completeTime).forEach(competeTimeQueue::offer);
        ArrayDeque<Integer> taskCountStack = new ArrayDeque<>();
        Arrays.stream(taskCount).forEach(taskCountStack::push);

        Map<String, Integer> ribberDuck = new LinkedHashMap<>();
        ribberDuck.put("Darth Vader Ducky", 0);
        ribberDuck.put("Thor Ducky", 0);
        ribberDuck.put("Big Blue Rubber Ducky", 0);
        ribberDuck.put("Small Yellow Rubber Ducky", 0);
        String type = null;

        boolean isTaskCompleted = false;
        while (!competeTimeQueue.isEmpty() && !taskCountStack.isEmpty()){

            int value = competeTimeQueue.peek() * taskCountStack.peek();

            if(value > 0 && value <= 60){
                int currentValue = ribberDuck.get("Darth Vader Ducky");
                ribberDuck.put("Darth Vader Ducky", currentValue + 1);
                competeTimeQueue.poll();
                taskCountStack.pop();
            }else if(value >= 61 && value <= 120){
                int currentValue = ribberDuck.get("Thor Ducky");
                ribberDuck.put("Thor Ducky", currentValue + 1);
                competeTimeQueue.poll();
                taskCountStack.pop();
            }else if(value >= 121 && value <= 180){
                int currentValue = ribberDuck.get("Big Blue Rubber Ducky");
                ribberDuck.put("Big Blue Rubber Ducky", currentValue + 1);
                competeTimeQueue.poll();
                taskCountStack.pop();
            }else if(value >= 181 && value <= 240){
                int currentValue = ribberDuck.get("Small Yellow Rubber Ducky");
                ribberDuck.put("Small Yellow Rubber Ducky", currentValue + 1);
                competeTimeQueue.poll();
                taskCountStack.pop();
            }else if(value > 240){
                int currentTask = taskCountStack.pop() - 2;
                taskCountStack.push(currentTask);

                int currentTime = competeTimeQueue.pop();
                competeTimeQueue.offer(currentTime);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        ribberDuck.entrySet().stream().forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
