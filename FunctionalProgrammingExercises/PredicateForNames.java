package FunctionalProgramming.Exersise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //дължината за сравнение
        String[] names = scanner.nextLine().split("\\s+");

        //predicate който взима името и връща true, ако дължината е <= n / false, ако дължината е > n;
        Predicate<String> checkValidLength = name -> name.length() <= n;
        //остават само отговарящите на условието
        Arrays.stream(names).filter(checkValidLength).forEach(System.out::println);
        //true -> оставя елемента в списъка
        //False -> маха елемент от списъка
    }
}
