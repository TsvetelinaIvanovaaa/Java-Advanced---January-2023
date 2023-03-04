package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixSize[0]);
        int cows = Integer.parseInt(matrixSize[1]);
        int [][] matrix = new int[rows][cows];

        for (int i = 0; i < rows; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cows; j++) {
                matrix[i][j] = Integer.parseInt(inputTokens[j]);
            }
        }
        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                if(matrix[i][j] == number){
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}
