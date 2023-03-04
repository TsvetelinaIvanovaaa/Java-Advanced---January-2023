package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String firstMatrixSize = scanner.nextLine();

        int firstMatrixRows = Integer.parseInt(firstMatrixSize.split("\\s+")[0]);
        int firstMatrixCows = Integer.parseInt(firstMatrixSize.split("\\s+")[1]);

        int [][] firstMatrix = new int[firstMatrixRows][firstMatrixCows];

        for (int i = 0; i < firstMatrixRows; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < firstMatrixCows; j++) {
                firstMatrix[i][j] = Integer.parseInt(inputTokens[j]);
            }
        }
        String[] secondMatrixSize = scanner.nextLine().split("\\s+");

        int secondMatrixRows = Integer.parseInt(secondMatrixSize[0]);
        int secondMatrixCows = Integer.parseInt(secondMatrixSize[1]);

        if(firstMatrixRows != secondMatrixRows || firstMatrixCows != secondMatrixCows){
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCows];
        for (int i = 0; i < secondMatrixRows; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < secondMatrixCows; j++) {
                secondMatrix[i][j] = Integer.parseInt((inputTokens[j]));
            }
        }
        for (int i = 0; i < firstMatrixRows; i++) {
            for (int j = 0; j < secondMatrixCows; j++) {
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
