package StreamsFilesAndDirectories.Exersises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        //прочитаме всички редове
        //обхождаме всеки един от редовете
        //отпечатваме всеки ред във друг файл с номер на реда
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("StreamsFilesAndDirectories/Exersises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output_line_numbers.txt");

        int number = 1;
        for (String line : allLines) {
            writer.println(number + ". " + line);
            number++;
        }
        writer.close();
    }
}
