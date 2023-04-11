package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        sumFirstDiagonal(matrix);
        sumSecondDiagonal(matrix);

        System.out.println(Math.abs(sumFirstDiagonal(matrix) - sumSecondDiagonal(matrix)));
    }

    private static int sumSecondDiagonal(int[][] matrix) {
        int sumSecondDiagonal = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(col == matrix.length - row - 1){
                    int currentElement = matrix[row][col];
                    sumSecondDiagonal += currentElement;
                }
            }
        }
        return sumSecondDiagonal;
    }

    private static int sumFirstDiagonal(int[][] matrix) {
        int sumFirstDiagonal = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(row == col){
                    int currentElement = matrix[row][col];
                    sumFirstDiagonal += currentElement;
                }
            }
        }
        return sumFirstDiagonal;
    }
}
