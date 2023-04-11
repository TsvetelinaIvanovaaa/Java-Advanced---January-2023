package StreamsFilesAndDirectories.Exersises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter("StreamsFilesAndDirectories/Exersises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            bw.write(line.toUpperCase());
            bw.newLine();
        }
        bw.close();
    }
}
