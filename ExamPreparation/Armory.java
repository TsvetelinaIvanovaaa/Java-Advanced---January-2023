package JavaAdvancedExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int officerRow = -1;
        int officerCol = -1;

        fillMatrix(scanner, matrix);

        List<Integer> mirrorCoordinates = new ArrayList<>();

        int countMirrors = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'A') {
                    matrix[row][col] = '-';
                    officerRow = row;
                    officerCol = col;
                }else if(matrix[row][col] == 'M'){
                    countMirrors++;
                    if(countMirrors == 2){
                        mirrorCoordinates.add(row);
                        mirrorCoordinates.add(col);
                        break;
                    }
                }
            }

        }
        int sales = 0;
        while (sales <= 65){

            String direction = scanner.nextLine();
            matrix[officerRow][officerCol] = '-';
            if(direction.equals("up")){
                officerRow--;
                if(officerRow < 0 || officerRow > matrix.length || officerCol < 0 || officerCol > matrix.length){
                    System.out.println("I do not need more swords!");
                    break;
                }else {
                    char currentSymbol = matrix[officerRow][officerCol];
                    if(Character.isDigit(currentSymbol)){
                        sales += Integer.parseInt(Character.toString(currentSymbol));
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == 'M'){
                        matrix[officerRow][officerCol] = '-';
                        officerRow = mirrorCoordinates.get(0);
                        officerCol = mirrorCoordinates.get(1);
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == '-'){
                        matrix[officerRow][officerCol] = 'A';
                    }
                }

            }else if(direction.equals("down")){
                officerRow++;
                if(officerRow < 0 || officerRow > matrix.length || officerCol < 0 || officerCol > matrix.length){
                    System.out.println("I do not need more swords!");
                    break;
                }else{
                    char currentSymbol = matrix[officerRow][officerCol];
                    if(Character.isDigit(currentSymbol)){
                        sales += Integer.parseInt(Character.toString(currentSymbol));
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == 'M'){
                        matrix[officerRow][officerCol] = '-';
                        officerRow = mirrorCoordinates.get(0);
                        officerCol = mirrorCoordinates.get(1);
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == '-'){
                        matrix[officerRow][officerCol] = 'A';
                    }
                }

            }else if(direction.equals("right")) {
                officerCol++;
                if(officerRow < 0 || officerRow > matrix.length || officerCol < 0 || officerCol > matrix.length){
                    System.out.println("I do not need more swords!");
                    break;
                }else {
                    char currentSymbol = matrix[officerRow][officerCol];
                    if(Character.isDigit(currentSymbol)){
                        sales += Integer.parseInt(Character.toString(currentSymbol));
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == 'M'){
                        matrix[officerRow][officerCol] = '-';
                        officerRow = mirrorCoordinates.get(0);
                        officerCol = mirrorCoordinates.get(1);
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == '-'){
                        matrix[officerRow][officerCol] = 'A';
                    }
                }

            }else if(direction.equals("left")){
                officerCol--;
                if(officerRow < 0 || officerRow > matrix.length || officerCol < 0 || officerCol > matrix.length){
                    System.out.println("I do not need more swords!");
                    break;
                }else{
                    char currentSymbol = matrix[officerRow][officerCol];
                    if(Character.isDigit(currentSymbol)){
                        sales += Integer.parseInt(Character.toString(currentSymbol));
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == 'M'){
                        matrix[officerRow][officerCol] = '-';
                        officerRow = mirrorCoordinates.get(0);
                        officerCol = mirrorCoordinates.get(1);
                        //matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol] = 'A';
                    }else if(matrix[officerRow][officerCol] == '-'){
                        matrix[officerRow][officerCol] = 'A';
                    }
                }
            }
        }

        if (sales < 65) {
            System.out.printf("The king paid %d gold coins.%n", sales);
            printMatrix(matrix, n);
        } else {
            System.out.println("Very nice swords, I will come back for more!");
            System.out.printf("The king paid %d gold coins.%n", sales);
            printMatrix(matrix, n);
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
    }
    private static void printMatrix(char[][] battlefield, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(battlefield[row][col]);
            }
            System.out.println();
        }
    }
}
