package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] matrixData = inputLine.split(",\\s+");

        int rows = Integer.parseInt(matrixData[0]);
        int cows = Integer.parseInt(matrixData[0]);
        String pattern = matrixData[1];

        int[][] matrix = new int[rows][cows];

        if(pattern.equals("A")){
            fillMatrixPatternA(matrix);
        }else{
            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
        
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int element = 1;
        for (int col = 0; col < matrix.length; col++) {
           // for (int col = 0; col < matrix.length; col++) {
                if(col % 2 == 0){
                    for (int row = 0; row < matrix.length; row++) {
                        matrix[row][col] = element;
                        element++;
                    }
                }else{
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        matrix[row][col] = element;
                        element++;
                    }
                }
            }
        }

    private static void fillMatrixPatternA(int[][] matrix) {
        int element = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[col][row] = element;
                element++;
            }
        }
    }
}
