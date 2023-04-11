package FunctionalProgramming.Exersise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        //начин 1:
        //for (String name : names) {
            //System.out.println(name);
        //}

        //начин 2:
        //приемаме име и го печатаме
        //Consumer<String> printName = name -> System.out.println(name);
        //for (String name : names) {
            //printName.accept(name);
        //}

        //начин 3:
        Consumer<String[]> printNames = array -> {
            for (String name : names) {
                System.out.println(name);
            }
        };
        printNames.accept(names);
    }
}
