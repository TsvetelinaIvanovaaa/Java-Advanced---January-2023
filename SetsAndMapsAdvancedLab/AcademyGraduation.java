package SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsData = new TreeMap<>();
        double averageScore = 0;
        double sum = 0;
        for (int i = 0; i < studentsCount; i++) {
            averageScore = 0;
            sum = 0;
            String name = scanner.nextLine();

            double[] scores = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double :: parseDouble).toArray();

            DecimalFormat df = new DecimalFormat("0.####");
            for (int j = 0; j < scores.length; j++) {
                double currentScore = scores[j];
                sum += currentScore;
            }
            averageScore = sum/scores.length;
            studentsData.put(name, averageScore);
        }
        for (Map.Entry<String, Double> entry : studentsData.entrySet()) {
            System.out.printf("%s is graduated with ", entry.getKey());
            System.out.print(new DecimalFormat("0.####################").format(entry.getValue()));
            System.out.println();
        }
    }
}
