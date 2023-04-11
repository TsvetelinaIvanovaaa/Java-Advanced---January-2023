package FunctionalProgramming.Exersise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer :: parseInt).collect(Collectors.toList());
        //приема лист -> връща цяло число - минимумът
        //приема лист -> отпечатва цяло число - минимумът
        //начин 1:
        //Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        //System.out.println(getMinNumber.apply(numbers));

        //начин 2:
        Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);

        //начин 3:
        //System.out.println(Collections.min(numbers));
    }
}
