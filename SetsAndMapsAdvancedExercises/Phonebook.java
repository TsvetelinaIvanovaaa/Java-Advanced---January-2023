package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("search")){
            String[] data = inputLine.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            if(!phoneBook.containsKey(name)){
                phoneBook.put(name, phoneNumber);
            }else{
                phoneBook.put(name, phoneNumber);
            }

            inputLine = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String searchName = input;
            if(phoneBook.containsKey(searchName)){
                System.out.printf("%s -> %s%n",searchName, phoneBook.get(searchName));
            }else{
                System.out.printf("Contact %s does not exist.%n",searchName);
            }

            input = scanner.nextLine();
        }
    }
}
