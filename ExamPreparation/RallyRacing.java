package JavaAdvancedExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        char[][] matrix = new char[n][n];

        fillMatrix(scanner, matrix);

        List<Integer> secondTunnelPosition = new ArrayList();

        int count = 0;
        chekForSekondTunnel(matrix, secondTunnelPosition, count);

        int carRow = 0;
        int carCol= 0;
        int kilometers = 0;

        boolean isFinish = false;
        String directions = scanner.nextLine();
        while (!directions.equals("End")){

            if(directions.equals("up")){
                carRow--;
                if(matrix[carRow][carCol] == '.'){
                    kilometers += 10;
                }else if(matrix[carRow][carCol] == 'F'){
                    isFinish = true;
                    kilometers += 10;
                    System.out.printf("Racing car %s finished the stage!%n", carNumber);
                    break;
                }else if(matrix[carRow][carCol] == 'T'){
                    matrix[carRow][carCol] = '.';
                    kilometers += 30;
                    carRow = secondTunnelPosition.get(0);
                    carCol = secondTunnelPosition.get(1);
                    matrix[carRow][carCol] = '.';
                }
            }else if(directions.equals("down")){
                carRow++;
                if(matrix[carRow][carCol] == '.'){
                    kilometers += 10;
                }else if(matrix[carRow][carCol] == 'F'){
                    isFinish = true;
                    kilometers += 10;
                    System.out.printf("Racing car %s finished the stage!%n", carNumber);
                    break;
                }else if(matrix[carRow][carCol] == 'T'){
                    matrix[carRow][carCol] = '.';
                    kilometers += 30;
                    carRow = secondTunnelPosition.get(0);
                    carCol = secondTunnelPosition.get(1);
                    matrix[carRow][carCol] = '.';
                }
            }else if(directions.equals("left")){
                carCol--;
                if(matrix[carRow][carCol] == '.'){
                    kilometers += 10;
                }else if(matrix[carRow][carCol] == 'F'){
                    isFinish = true;
                    kilometers += 10;
                    System.out.printf("Racing car %s finished the stage!%n", carNumber);
                    break;
                }else if(matrix[carRow][carCol] == 'T'){
                    matrix[carRow][carCol] = '.';
                    kilometers += 30;
                    carRow = secondTunnelPosition.get(0);
                    carCol = secondTunnelPosition.get(1);
                    matrix[carRow][carCol] = '.';
                }
            }else if(directions.equals("right")){
                carCol++;
                if(matrix[carRow][carCol] == '.'){
                    kilometers += 10;
                }else if(matrix[carRow][carCol] == 'F'){
                    isFinish = true;
                    kilometers += 10;
                    System.out.printf("Racing car %s finished the stage!%n", carNumber);
                    break;
                }else if(matrix[carRow][carCol] == 'T'){
                    matrix[carRow][carCol] = '.';
                    kilometers += 30;
                    carRow = secondTunnelPosition.get(0);
                    carCol = secondTunnelPosition.get(1);
                    matrix[carRow][carCol] = '.';
                }
            }

            directions = scanner.nextLine();
        }
        matrix[carRow][carCol] = 'C';

        if(isFinish){
            System.out.printf("Distance covered %d km.%n",kilometers);
            printMatrix(n, matrix);
        }else{
            System.out.printf("Racing car %s DNF.%n",carNumber);
            System.out.printf("Distance covered %d km.%n",kilometers);
            printMatrix(n, matrix);
        }
    }

    private static void printMatrix(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void chekForSekondTunnel(char[][] matrix, List<Integer> secondTunnelPosition, int count) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == 'T'){
                    count++;
                    if(count == 2){
                        secondTunnelPosition.add(row);
                        secondTunnelPosition.add(col);
                        break;
                    }
                }
            }
        }
    }


    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
    }
}
