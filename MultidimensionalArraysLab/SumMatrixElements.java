package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] matrixSize = inputLine.split(",\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cows = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cows];

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] rowData = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < cows; j++) {
                matrix[i][j] = Integer.parseInt(rowData[j]);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(cows);
        System.out.println(sum);
    }
}
