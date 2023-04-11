package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double[] numbersArr = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double :: parseDouble)
                .toArray();

        Map<Double, Integer> numbersOccurrence = new LinkedHashMap<>();

        for (int i = 0; i < numbersArr.length; i++) {
            double currentNumber = numbersArr[i];

            if(!numbersOccurrence.containsKey(currentNumber)){
                numbersOccurrence.put(currentNumber, 1);
            }else{
                int currentValue = numbersOccurrence.get(currentNumber);
                numbersOccurrence.put(currentNumber, currentValue + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbersOccurrence.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }
    }
}
