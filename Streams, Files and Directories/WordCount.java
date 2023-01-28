package StreamsFilesAndDirectories.Exersises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        //думи, които ще броим в друг фаил
        String pathWord = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        //дума -> брой срещания
        Map<String, Integer> countWords = new HashMap<>();

        //четем всички думи от файла и всяка дума я съхраняваме в мап
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWord));
        for (String lineWithWords : allLinesWithWords) {
            Arrays.stream(lineWithWords.split("\\s+")).forEach(
                    word -> {
                        countWords.put(word, 0);
                    }
            );
        }
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if(countWords.containsKey(word)){
                    int currentCount = countWords.get(word);
                    countWords.put(word, currentCount + 1);

                }
            });
        }
        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}

