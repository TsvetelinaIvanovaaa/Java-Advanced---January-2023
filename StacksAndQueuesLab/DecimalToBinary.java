package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(decimal == 0){
            System.out.println(0);
        }else{
            while (decimal != 0){
                int leftOver = decimal % 2;
                stack.push(leftOver);
                decimal = decimal/2;
            }
        }

        //int stackSize = stack.size();
        //for (int i = 0; i < stack.size(); i++) {
        //    System.out.print(stack.pop());
        //}

        for (Integer integer : stack) { //(stack.iter)
            System.out.print(integer);
        }
    }
}


