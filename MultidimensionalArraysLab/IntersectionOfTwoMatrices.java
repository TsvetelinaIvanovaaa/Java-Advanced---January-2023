package MultidimensionalArrays.Lab;

import java.sql.SQLOutput;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cows = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cows];
        char[][] secondMatrix = new char[rows][cows];

        for (int i = 0; i < rows; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cows; j++) {
                firstMatrix[i][j] = inputTokens[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cows; j++) {
                secondMatrix[i][j] = inputTokens[j].charAt(0);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firstMatrix[i][j] + " ");
                }else{
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
