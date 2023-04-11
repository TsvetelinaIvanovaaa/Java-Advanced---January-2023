package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        int[][] subMatrix = new int[3][3];

        fillMatrix(scanner, rows, cols, matrix);

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int element1 = -1;
        int element2 = -1;
        int element3 = -1;
        int element4 = -1;
        int element5 = -1;
        int element6 = -1;
        int element7 = -1;
        int element8 = -1;
        int element9 = -1;

        for (int row = 0; row < matrix.length-2; row++) {
            currentSum = 0;
            for (int col = 0; col < matrix[0].length-2; col++) {
                currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2] + matrix[row+1][col] +
                        matrix[row+1][col+1] + matrix[row+1][col+2] + matrix[row+2][col] + matrix[row+2][col+1] +
                        matrix[row+2][col+2];

                if(currentSum > maxSum){
                    maxSum = currentSum;
                    element1 = matrix[row][col];
                    element2 = matrix[row][col+1];
                    element3 = matrix[row][col+2];
                    element4 = matrix[row+1][col];
                    element5 = matrix[row+1][col+1];
                    element6 = matrix[row+1][col+2];
                    element7 = matrix[row+2][col];
                    element8 = matrix[row+2][col+1];
                    element9 = matrix[row+2][col+2];
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        System.out.println(element1 + " " + element2 + " " + element3);
        System.out.println(element4 + " " + element5 + " " + element6);
        System.out.println(element7 + " " + element8 + " " + element9);
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
