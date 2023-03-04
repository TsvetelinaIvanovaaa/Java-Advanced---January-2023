package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows = 8;
        int cows = 8;

        char[][] matrix = new char[8][8];

        for (int i = 0; i < rows; i++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cows; j++) {
                matrix[i][j] = rowData[j].charAt(0);
            }
        }
        int rowPosition = -1;
        int cowPosition = -1;
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                char currentElement = matrix[i][j];
                if(currentElement == 'q'){
                    rowPosition = i;
                    cowPosition = j;
                    for (int k = i; k < matrix.length -1; k++) {
                        char nextElement = matrix[k][i];
                        if(nextElement == 'q'){
                            isFound = true;
                            break;
                        }else{
                            isFound = false;
                        }
                    }
                    for (int k = i; k >= 0 ; k--) {
                        char nextElement = matrix[k][i];
                        if(nextElement == 'q'){
                            isFound = true;
                            break;
                        }else{
                            isFound = false;
                        }
                    }
                    for (int k = j; k <matrix[j].length -1 ; k++) {
                        char nextElement = matrix[k][j];
                        if(nextElement == 'q'){
                            isFound = true;
                            break;
                        }else{
                            isFound = false;
                        }
                    }
                    for (int k = j; k >= 0 ; k--) {
                        char nextElement = matrix[k][j];
                        if (nextElement == 'q'){
                            isFound = true;
                            break;
                        }else{
                            isFound = false;
                        }
                    }
                }
            }
        }
    }
}
