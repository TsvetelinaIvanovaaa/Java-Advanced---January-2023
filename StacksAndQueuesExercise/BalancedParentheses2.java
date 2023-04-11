package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        ArrayDeque<Character> closedBracketsQueue = new ArrayDeque<>();

        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBracketsStack.push(currentBracket);
            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                closedBracketsQueue.offer(currentBracket);
            }
        }
        if (openBracketsStack.size() != closedBracketsQueue.size()) {
            System.out.println("NO");
        } else { //еднакъв брой отворени и затворени
            while (!openBracketsStack.isEmpty() && !closedBracketsQueue.isEmpty()) {
                char lastOpen = openBracketsStack.pop();
                char firstClose = closedBracketsQueue.poll();
                if(lastOpen == '{' && firstClose == '}'){
                    areBalanced = true;
                }else if(lastOpen == '[' && firstClose == ']'){
                    areBalanced = true;
                }else if(lastOpen == '(' && firstClose == ')'){
                    areBalanced = true;
                }else{
                    areBalanced = false;
                    break;
                }
            }
            if(areBalanced){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
