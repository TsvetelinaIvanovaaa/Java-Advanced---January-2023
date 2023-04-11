package FunctionalProgramming.Exersise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        //revers на листа
        Collections.reverse(numbers);
        //премахваме всички числа от списъка, които се делят на n;
        //приема число -> връща true/false

        //начин 1:
        //Predicate<Integer> checkDivision = number -> number % n == 0;
        //numbers.removeIf(checkDivision);

        //начин 2:
        Predicate<Integer> checkDivision = number -> number % n != 0;
        numbers = numbers.stream().filter(checkDivision).collect(Collectors.toList());

        numbers.forEach(number -> System.out.print(number + " "));
    }
}
