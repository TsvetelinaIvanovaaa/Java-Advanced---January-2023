package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] tokens = inputLine.split(" ");

        ArrayDeque<String> numbers = new ArrayDeque<>();
        Collections.addAll(numbers, tokens);

        while (numbers.size() > 1){
            int firstNumber = Integer.parseInt(numbers.pop());
            String sign = numbers.pop();
            int secondNumber = Integer.parseInt(numbers.pop());
            int result = 0;

            if(sign.equals("+")){
                result = firstNumber + secondNumber;
                numbers.push(String.valueOf(result));
            }else{
                result = firstNumber - secondNumber;
                numbers.push(String.valueOf(result));
            }
        }
        System.out.println(numbers.peek());
    }
}
