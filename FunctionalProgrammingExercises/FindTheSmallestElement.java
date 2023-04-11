package FunctionalProgramming.Exersise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        //начин 1:
        //лист -> отпечатаме индекса на най-малкия елемент
        Consumer<List<Integer>> printIndexOfMinElement = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        printIndexOfMinElement.accept(numbers);
        //начин 2:
        //лист -> върна индекса на най-малкия елемент
        //indexOf -> връща първия индекса на който срещаме елемента (минималния елемент)
        //lastIndexOf -> връща последния индекс, на който срещаме елемента (минималния елемент)
        //Function<List<Integer>, Integer> getIndexMinElement = list -> list.lastIndexOf(Collections.min(list));
        //System.out.println(getIndexMinElement.apply(numbers));
    }
}
