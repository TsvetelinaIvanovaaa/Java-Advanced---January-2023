package JavaAdvancedExamPreparation;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[n][m];

        feelMatrix(scanner, matrix);

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    matrix[row][col] = '-';
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        int moveMade = 0;
        int peopleTouched = 0;
        while (!command.equals("Finish")) {

            int row = startRow;
            int col = startCol;


            if (peopleTouched == 3) {
                break;
            }
            if (command.equals("right")) {
                startCol++;
                if (startRow >= 0 && startRow < matrix.length && startCol >= 0 && startCol < matrix.length) {
                    if (matrix[startRow][startCol] == '-') {
                        moveMade++;
                    } else if (matrix[startRow][startCol] == 'P') {
                        peopleTouched++;
                        moveMade++;
                        matrix[startRow][startCol] = '-';
                    }else if(matrix[startRow][startCol] == 'O'){
                        startRow = row;
                        startCol = col;
                    }
                }else{
                    startRow = row;
                    startCol = col;
                }
            } else if (command.equals("left")) {
                startCol--;
                if (startRow >= 0 && startRow < matrix.length && startCol >= 0 && startCol < matrix.length) {
                    if (matrix[startRow][startCol] == '-') {
                        moveMade++;
                    } else if (matrix[startRow][startCol] == 'P') {
                        peopleTouched++;
                        moveMade++;
                        matrix[startRow][startCol] = '-';
                    }else if(matrix[startRow][startCol] == 'O'){
                        startRow = row;
                        startCol = col;
                    }
                }else{
                    startRow = row;
                    startCol = col;
                }
            } else if (command.equals("up")) {
                startRow--;
                if (startRow >= 0 && startRow < matrix.length && startCol >= 0 && startCol < matrix.length) {
                    if (matrix[startRow][startCol] == '-') {
                        moveMade++;
                    } else if (matrix[startRow][startCol] == 'P') {
                        peopleTouched++;
                        moveMade++;
                        matrix[startRow][startCol] = '-';
                    }else if(matrix[startRow][startCol] == 'O'){
                        startRow = row;
                        startCol = col;
                    }
                }else{
                    startRow = row;
                    startCol = col;
                }
            } else if (command.equals("down")) {
                startRow++;
                if (startRow >= 0 && startRow < matrix.length && startCol >= 0 && startCol < matrix.length) {
                    if (matrix[startRow][startCol] == '-') {
                        moveMade++;
                    } else if (matrix[startRow][startCol] == 'P') {
                        peopleTouched++;
                        moveMade++;
                        matrix[startRow][startCol] = '-';
                    }else if(matrix[startRow][startCol] == 'O'){
                        startRow = row;
                        startCol = col;
                    }
                }
            }else{
                startRow = row;
                startCol = col;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n",peopleTouched,moveMade);
}

    private static void feelMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                matrix[row][i] = input[i].charAt(0);
            }
        }
    }
}
