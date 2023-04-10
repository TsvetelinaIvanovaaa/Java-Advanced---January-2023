package JavaAdvancedExamPreparation;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] battlefield = new char[n][n];

        fillBattlefield(battlefield, n, scanner);
        int submarineRow = -1;
        int submarineCol = -1;
        int countMine = 0;
        int countCruiser = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = battlefield[row][col];
                if(currentSymbol == 'S'){
                    submarineRow = row;
                    submarineCol = col;
                    battlefield[row][col] = '-';
                }
            }
        }


        while (countMine < 3 && countCruiser < 3){
            String command = scanner.nextLine();

            if(command.equals("up")){
                submarineRow--;
                if (battlefield[submarineRow][submarineCol] == '-') {
                    continue;
                }else if(battlefield[submarineRow][submarineCol] == '*'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countMine++;
                }else if(battlefield[submarineRow][submarineCol] == 'C'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countCruiser++;
                }
            }else if(command.equals("down")){
                submarineRow++;
                if (battlefield[submarineRow][submarineCol] == '-') {
                    continue;
                }else if(battlefield[submarineRow][submarineCol] == '*'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countMine++;
                }else if(battlefield[submarineRow][submarineCol] == 'C'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countCruiser++;
                }
            }else if(command.equals("left")){
                submarineCol--;
                if (battlefield[submarineRow][submarineCol] == '-') {
                    continue;
                }else if(battlefield[submarineRow][submarineCol] == '*'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countMine++;
                }else if(battlefield[submarineRow][submarineCol] == 'C'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countCruiser++;
                }
            }else if(command.equals("right")){
                submarineCol++;
                if (battlefield[submarineRow][submarineCol] == '-') {
                    continue;
                }else if(battlefield[submarineRow][submarineCol] == '*'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countMine++;
                }else if(battlefield[submarineRow][submarineCol] == 'C'){
                    battlefield[submarineRow][submarineCol] = '-';
                    countCruiser++;
                }
            }
            if(countCruiser == 3){
                battlefield[submarineRow][submarineCol] = 'S';
            }
            if(countMine == 3){
                battlefield[submarineRow][submarineCol] = 'S';
            }
            if(submarineCol < 0 || submarineCol >= n || submarineRow < 0 || submarineCol >= n){
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!",submarineRow,submarineCol);
                printBattlefield(battlefield, n);
                break;
            }
        }

        if(countMine == 3){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",submarineRow,submarineCol);
            printBattlefield(battlefield, n);
        }else if(countCruiser == 3){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
            printBattlefield(battlefield, n);
        }
    }

    private static void printBattlefield(char[][] battlefield, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(battlefield[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillBattlefield(char[][] battlefield, int n, Scanner scanner) {
        for (int row = 0; row < n; row++) {
            String[]rowData = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                battlefield[row][col] = rowData[col].charAt(0);
            }
        }
    }
}
