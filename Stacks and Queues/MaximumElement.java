package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= commandsCount; i++) {
            String commandLine = scanner.nextLine();
            String[] tokens = commandLine.split(" ");

            int commandType = Integer.parseInt(tokens[0]);

            if(commandType == 1){
                int element = Integer.parseInt(tokens[1]);
                stack.push(element);
            }else if(commandType == 2){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(commandType == 3){
                System.out.println(Collections.max(stack));
            }
        }
    }
}