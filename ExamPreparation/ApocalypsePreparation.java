package JavaAdvancedExamPreparation;

import java.util.*;

public class ApocalypsePreparation {
    private static final int PATCH = 30;
    private static final int BANDAGE = 40;
    private static final int MEDKIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicament = new ArrayDeque<>();
        Map<String, Integer> items = new TreeMap<>();

        int[] textilesArray = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int[] medicamentArray = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < textilesArray.length; i++) {
            textiles.offer(textilesArray[i]);
        }
        for (int i = 0; i < medicamentArray.length; i++) {
            medicament.push(medicamentArray[i]);
        }

        while (!textiles.isEmpty() && !medicament.isEmpty()) {
            int sum = textiles.peek() + medicament.peek();
            textiles.poll();
            if (sum == 30) {
                if (!items.containsKey("Patch")) {
                    items.put("Patch", 1);
                    medicament.pop();
                } else {
                    int currentValue = items.get("Patch");
                    items.put("Patch", currentValue + 1);
                    medicament.pop();
                }
            } else if (sum == 40) {
                if (!items.containsKey("Bandage")) {
                    items.put("Bandage", 1);
                    medicament.pop();
                } else {
                    int currentValue = items.get("Bandage");
                    items.put("Bandage", currentValue + 1);
                    medicament.pop();
                }
            } else if (sum == 100) {
                if (!items.containsKey("MedKit")) {
                    items.put("MedKit", 1);
                    medicament.pop();
                } else {
                    int currentValue = items.get("MedKit");
                    items.put("MedKit", currentValue + 1);
                    medicament.pop();
                }
            } else if (sum > 100) {
                if (!items.containsKey("MedKit")) {
                    items.put("MedKit", 1);
                    medicament.pop();
                    int newMedicament = medicament.pop() + (sum - 100);
                    medicament.push(newMedicament);
                } else {
                    int currentValue = items.get("MedKit");
                    items.put("MedKit", currentValue + 1);
                    medicament.pop();
                    int newMedicament = medicament.pop() + (sum - 100);
                    medicament.push(newMedicament);
                }
            } else {
                int newMedicament = medicament.pop() + 10;
                medicament.push(newMedicament);
            }
        }
        if (textiles.isEmpty() && medicament.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            items
                    .entrySet()
                    .stream()
                    .sorted(
                            (left, right) -> {
                                return right.getValue().compareTo(left.getValue());
                            }
                    )
                    .forEach(entry -> System.out.println
                            (entry.getKey() +" " + "-" + " " + entry.getValue()));
        } else if (textiles.isEmpty() && !medicament.isEmpty()) {
            System.out.println("Textiles are empty.");
            items
                    .entrySet()
                    .stream()
                    .sorted(
                            (left, right) -> {
                                return right.getValue().compareTo(left.getValue());
                            }
                    )
                    .forEach(entry -> System.out.println
                            (entry.getKey() +" " + "-" + " " + entry.getValue()));
            System.out.print("Medicaments left: ");
            for (int medicate : medicament) {
                if (medicament.size() != 1) {
                    System.out.print(medicament.pop() + ", ");
                } else {
                    System.out.print(medicament.pop());
                }
            }

        } else if (!textiles.isEmpty() && medicament.isEmpty()) {
            System.out.println("Medicaments are empty.");
            items
                    .entrySet()
                    .stream()
                    .sorted(
                            (left, right) -> {
                                return right.getValue().compareTo(left.getValue());
                            }
                    )
                    .forEach(entry -> System.out.println
                            (entry.getKey() +" " + "-" + " " + entry.getValue()));
            System.out.print("Textiles left: ");
            for (int textile : textiles) {
                if (textiles.size() != 1) {
                    System.out.print(textiles.poll() + ", ");
                } else {
                    System.out.println(textiles.poll());
                }
            }
        }
    }
}
