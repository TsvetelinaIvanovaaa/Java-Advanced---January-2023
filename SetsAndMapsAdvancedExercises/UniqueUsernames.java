package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Set<String> data = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String username = scanner.nextLine();
            data.add(username);
        }
        for (String username : data) {
            System.out.println(username);
        }
    }
}
