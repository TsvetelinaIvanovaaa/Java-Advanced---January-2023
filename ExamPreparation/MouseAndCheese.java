package JavaAdvancedExamPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int mouseRow = -1;
        int mouseCol = -1;
        int countCheese = 0;

        for (int row = 0; row < n; row++) {
            String rowContent = scanner.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }

        //намираме къде е текущата позиция на мишката
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if(currentSymbol == 'M'){
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String direction = scanner.nextLine();

        while (!direction.equals("end")){
            matrix[mouseRow][mouseCol] = '-';
            switch (direction){
                case "up":
                    //намаляме реда с 1
                    mouseRow--;
                    break;
                case "down":
                    //увеличаваме реда с 1
                    mouseRow++;
                    break;
                case "left":
                    //намаляме колоната с 1;
                    mouseCol--;
                    break;
                case "right":
                    //увеличаваме колоната с 1
                    mouseCol++;
                    break;
            }
            //преди да поставим мишката на новото й място, проверяваме дали реда и колоната са валидни
            if(mouseCol < 0 || mouseCol >= n || mouseRow < 0 || mouseRow >= n){
                System.out.println("Where is the mouse?");
                break;
            }
            //проверяваме местото на което ще отиде мишката дали е В или С
            if(matrix[mouseRow][mouseCol] == 'c'){
                countCheese ++;
            }else if(matrix[mouseRow][mouseCol] == 'B'){
                continue;
            }
            //ако кооординатите са валидни поставяме мишката на новото местоположение
            matrix[mouseRow][mouseCol] = 'M';

            direction = scanner.nextLine();
        }
        if(countCheese >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",countCheese);
        }else{
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-countCheese);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
