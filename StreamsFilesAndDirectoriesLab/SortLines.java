package StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);
        System.out.println();
    }
}
