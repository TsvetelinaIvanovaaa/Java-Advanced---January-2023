package StacksAndQueues.Exercises;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //получаваме числа разделени с интервал
        //1.всички числа да ги сложим в стека

        //2.повтаряме: вадим число от стека -> докато стека е пълен
        //спираме: когато стека стане празен

        String input = scanner.nextLine();
        String[] inputNumbers = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        //начин 1 да напълним стека: addAll(List.of(inputNumbers)) -> пълни го като опашка
        //начин 2: foreach цикъл
        for (String number : inputNumbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
