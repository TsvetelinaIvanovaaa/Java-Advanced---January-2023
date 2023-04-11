package FunctionalProgramming.Exersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        //add -> добавя 1 към всеки елемент на списъка -> приемаме списък -> връщаме списък с модифицирани елементи
        Function<List<Integer>, List<Integer>> add = list -> list.stream()
                .map(number -> number += 1).collect(Collectors.toList());
        //multiply -> умножаваме всеки елемент по 2 -> приемаме списък -> връщаме списък с модифицирани елементи
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream()
                .map(number -> number *= 2).collect(Collectors.toList());
        //subtract -> изважда от всеки елемент от листа 1 -> приемаме списък -> връщаме списък с модифицирани елементи
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream()
                .map(number -> number -= 1).collect(Collectors.toList());
        //print -> принтира всички елементи на списъка на нов ред -> приемаме списък -> отпечатваме всеки елемент
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
