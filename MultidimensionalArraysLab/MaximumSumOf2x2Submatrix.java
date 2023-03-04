package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] matrixSize = inputLine.split(",\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cows = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cows];

        for (int i = 0; i < rows; i++) {
            String[] rowData = scanner.nextLine().split(",\\s+");
            for (int j = 0; j <cows ; j++) {
                matrix[i][j] = Integer.parseInt(rowData[j]);
            }
        }
        int sum = Integer.MIN_VALUE;
        int allSum = 0;
        int biggestSumRow1 = -1;
        int biggestSumCols2 = -1;
        int biggestSumRow2 = -1;
        int biggestSumCols1 = -1;
        for (int i = 0; i < matrix.length -1; i++) {
            for (int j = 0; j < matrix[i].length -1; j++) {
                int currentSum = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] + matrix[i+1][j+1] ;
                if(currentSum > sum){
                    sum = currentSum;
                    biggestSumRow1 = matrix[i][j];
                    biggestSumRow2 = matrix[i + 1][j];
                    biggestSumCols1 = matrix[i + 1][j + 1];
                    biggestSumCols2 = matrix[i][j + 1];
                }
            }
        }
        System.out.println(biggestSumRow1 + " " + biggestSumCols2);
        System.out.println(biggestSumRow2 + " " + biggestSumCols1);
        System.out.println(sum);
    }
}
