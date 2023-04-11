package SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Set<String> uniqueElements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String inputLine = scanner.nextLine();
            String[] chemicalElements = inputLine.split("\\s+");

            uniqueElements.addAll(Arrays.asList(chemicalElements));
        }
        for (String element : uniqueElements) {
            System.out.printf("%s ",element);
        }
    }
}
