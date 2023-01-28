package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        int n = scanner.nextInt(); //брой на елементите, които трябва да добавя в стека
        int s = scanner.nextInt(); //брой елементи, които трябва да премахнем от стека
        int x = scanner.nextInt(); // дали числото го има в стека

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //добавяне -> n на брой пъти
        for (int i = 1; i <= n; i++) {
            queue.offer(scanner.nextInt()); //сканирай ми(вземи ми) първото цяло число
        }
        //премахване-> s на брой пъти
        for (int i = 1; i <= s; i++) {
            queue.poll();
        }
        //проверка дали х го има в стека
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            //ако има елементи в стека отпечатваме кой е минималният елемент
            //няма елементи в стека -> 0
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue)); //дава минималният елемент в някаква колекция
            } else {
                System.out.println(0);
            }
        }
    }
}
