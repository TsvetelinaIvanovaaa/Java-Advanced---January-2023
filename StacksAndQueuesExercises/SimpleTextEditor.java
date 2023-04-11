package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();

        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 1; i <= countCommands ; i++) {
            String command = scanner.nextLine();
            //•	"1 {string}" - appends.split(" "); -> ["1","{string}"]
            //•	"2 {count}" - erases
            //•	"3 {index}" - returns
            //•	"4" - undoes
            int commandNumber = Integer.parseInt(command.split("\\s+")[0]);
            switch (commandNumber){
                case 1:
                    textStack.push(currentText.toString());
                    String stringForAppend = command.split("\\s+")[1];
                    //трябва да добавя stringForAppend към сегашният текст
                    currentText.append(stringForAppend);
                    break;
                case 2:
                    textStack.push(currentText.toString());
                    int countElementsForDelete = Integer.parseInt(command.split("\\s+")[1]);
                    //изтриваме съответния брой елементи -> countElementsForDelete
                    int startIndexForDelete = currentText.length() - countElementsForDelete;
                    currentText.delete(startIndexForDelete, startIndexForDelete + countElementsForDelete);
                    break;
                case 3:
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    //печатаме елемента на дадения индекс
                    System.out.println(currentText.charAt(index -1));
                    break;
                case 4:
                    if(!textStack.isEmpty()){
                        currentText = new StringBuilder(textStack.pop());
                    }
                    break;
            }
        }

    }
}
