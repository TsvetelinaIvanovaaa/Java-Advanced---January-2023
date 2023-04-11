package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //последната отворена скоба трябва да съвпада с последната затворена скоба
        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            //проверка за отворена скоба -> {,[,(
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBracketsStack.push(currentBracket);
                //проверка за затворена скоба
            }else if(currentBracket == '}' || currentBracket == ']' || currentBracket == ')'){
                //последната отворена съвпада с текущата затворена
                if(openBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBracketsStack.pop();
                //проверка дали текущата затворена съвпада с последната отворена
                if(currentBracket == '}' && lastOpen == '{'){
                    //balance
                    areBalanced = true;
                }else if(currentBracket == ']' && lastOpen == '['){
                    areBalanced = true;
                }else if(currentBracket == ')' && lastOpen == '('){
                    areBalanced = true;
                }else{
                    //not balance
                    areBalanced = false;
                    break;
                }
            }
        }
        //преминали през всички скоби
        //ако има баланс -> YES
        if(areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}