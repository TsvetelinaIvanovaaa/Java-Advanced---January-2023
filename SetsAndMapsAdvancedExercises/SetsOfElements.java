package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String inputLine = scanner.nextLine();

        int firstSetSize = Integer.parseInt(inputLine.split("\\s+")[0]);
        int secondSetSize = Integer.parseInt(inputLine.split("\\s+")[1]);

        for (int i = 1; i <= firstSetSize ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 1; i <= secondSetSize ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
        firstSet.retainAll(secondSet);
        for (int number : firstSet) {
            System.out.printf("%d ",number);
        }
    }
}
