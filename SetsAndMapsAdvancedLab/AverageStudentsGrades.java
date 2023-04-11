package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.Scanner;


public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countStudents; i++) {
            String studentsData = scanner.nextLine();
            String[] tokens = studentsData.split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if(!studentsGrades.containsKey(studentName)){
                studentsGrades.put(studentName, new ArrayList<>());
                studentsGrades.get(studentName).add(grade);

            }else{
                studentsGrades.get(studentName).add(grade);
            }

        }
        studentsGrades.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double avgSum = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", avgSum);
                });
    }
}
