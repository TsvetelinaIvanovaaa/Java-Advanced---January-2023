package JavaAdvancedExamPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char [][] field = new char[rows][rows];

        //въвеждаме полето
        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }

        //намираме къде е Прис първоначално
        int parisRow = 0;
        int parisCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col] == 'P'){
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        while (true){
            String command = scanner.nextLine();
            //"{direction} {row have spartan} {col have spartan}".split(" ") -> ["dir", "row", "col"]
            String direction = command.split(" ")[0];
            int enemyRow = Integer.parseInt(command.split(" ")[1]);
            int enemyCol = Integer.parseInt(command.split(" ")[2]);

            field[parisRow][parisCol] = '-';
            field[enemyRow][enemyCol] = 'S';
            //преместване
            switch (direction){
                case "up":
                    if(parisRow -1 >= 0){
                        parisRow--;
                    }
                    break;
                case "down":
                    if(parisRow + 1 < field.length){
                        parisRow ++;
                    }
                    break;
                case "left":
                    if(parisCol - 1 >= 0){
                        parisCol--;
                    }
                    break;
                case "right":
                    if(parisCol + 1 < field.length){
                        parisCol++;
                    }
                    break;
            }
            //след преместване
            //1. намаляване на енергията с 1
            energy--;
            //2.проверява дали е умрял
            if(energy <= 0){
                parisDead(field, parisRow, parisCol);
                return;
            }
            //има ли спартанец там където се е преместил
            if(field[parisRow][parisCol] == 'S'){
                //3.1. победа нас спартанеца -> намаляме енергията с 2
                energy -= 2;
                //3.2. проверка дали енергията е <= 0
                if(energy <= 0){
                    parisDead(field, parisRow, parisCol);
                    return;
                }else{
                    field[parisRow][parisCol] = '-';
                }
            }else if(field[parisRow][parisCol] == 'H'){
                //4.1. на мястото където е Елена слагаме "-"
                field[parisRow][parisCol] = '-';
                //4.2. отпечатване ->останала енергия
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",energy);
                //4.3. отпечатваме матрицата
                printField(field);
                return;
            }
        }
    }
    public static void parisDead(char [][]field, int parisRow, int parisCol){
            //Парис умира
            //1.там където е бил слагаме Х
            field[parisRow][parisCol] = 'X';
            //2.отпечатваме къде е умрял
            System.out.printf("Paris died at %d;%d.%n",parisRow,parisCol);
            //3. отпечатваме матрицата
            printField(field);
    }
    public static void printField(char[][]field){
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
