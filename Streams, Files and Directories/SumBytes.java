package StreamsFilesAndDirectories.Exersises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0; //сумата от всички символи във файла
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while (line != null){
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            line = br.readLine();
        }
        System.out.println(sum);
    }
}
