package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> collectionsURL = new ArrayDeque<>();
        String currentURL = " ";
        while (!input.equals("Home")){
            if(input.equals("back")){
                if(collectionsURL.size() > 1){
                    collectionsURL.pop();
                    currentURL = collectionsURL.peek();
                    System.out.println(currentURL);
                }else{
                    System.out.println("no previous URLs");
                }
            }else{
                collectionsURL.push(input);
                currentURL = collectionsURL.peek();
                System.out.println(currentURL);
            }
            input = scanner.nextLine();
        }
    }
}

