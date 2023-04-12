package RetakeExam;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] directions = scanner.nextLine().split(",\\s+");

        char[][] matrix = new char[n][n];
        int squirrelRow = -1;
        int squirrelCol = -1;
        int countHazelnuts = 0;

        fillMatrix(scanner, n, matrix);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                    break;
                }
            }
        }
        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            if (countHazelnuts == 3) {
                break;
            }
            if (direction.equals("up")) {
                squirrelRow--;
                if (squirrelRow < 0 || squirrelRow >= matrix.length || squirrelCol < 0 || squirrelCol >= matrix.length) {
                    System.out.println("The squirrel is out of the field.");
                    System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                    return;
                }else{
                    if (matrix[squirrelRow][squirrelCol] == 'h') {
                        countHazelnuts++;
                        matrix[squirrelRow][squirrelCol] = '*';

                    } else if (matrix[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                        return;
                    } else if (matrix[squirrelRow][squirrelCol] == '*') {
                        continue;
                    }
                }
            } else if (direction.equals("down")) {
                squirrelRow++;
                if (squirrelRow < 0 || squirrelRow >= matrix.length || squirrelCol < 0 || squirrelCol >= matrix.length) {
                    System.out.println("The squirrel is out of the field.");
                    System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                    return;
                }else{
                    if (matrix[squirrelRow][squirrelCol] == 'h') {
                        countHazelnuts++;
                        matrix[squirrelRow][squirrelCol] = '*';

                    } else if (matrix[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                        return;
                    } else if (matrix[squirrelRow][squirrelCol] == '*') {
                        continue;
                    }
                }
            } else if (direction.equals("left")) {
                squirrelCol--;
                if (squirrelRow < 0 || squirrelRow >= matrix.length || squirrelCol < 0 || squirrelCol >= matrix.length) {
                    System.out.println("The squirrel is out of the field.");
                    System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                    return;
                }else{
                    if (matrix[squirrelRow][squirrelCol] == 'h') {
                        countHazelnuts++;
                        matrix[squirrelRow][squirrelCol] = '*';

                    } else if (matrix[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                        return;
                    } else if (matrix[squirrelRow][squirrelCol] == '*') {
                        continue;
                    }
                }
            } else if (direction.equals("right")) {
                squirrelCol++;
                if (squirrelRow < 0 || squirrelRow >= matrix.length || squirrelCol < 0 || squirrelCol >= matrix.length) {
                    System.out.println("The squirrel is out of the field.");
                    System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                    return;
                } else {
                    if (matrix[squirrelRow][squirrelCol] == 'h') {
                        countHazelnuts++;
                        matrix[squirrelRow][squirrelCol] = '*';

                    } else if (matrix[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
                        return;
                    } else if (matrix[squirrelRow][squirrelCol] == '*') {
                        continue;
                    }
                }
            }
        }

        if (countHazelnuts == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
            System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
        } else {
            System.out.println("There are more hazelnuts to collect.");
            System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
        }
    }
    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String rowContent = scanner.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
    }
}
