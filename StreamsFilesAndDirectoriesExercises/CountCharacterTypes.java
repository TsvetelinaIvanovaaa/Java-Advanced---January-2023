package StreamsFilesAndDirectories.Exersises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        int vowelIsCount = 0; //броя на гласните букви
        int punctCount = 0; //броя на пунктуационните знаци
        int consonantsCount = 0; //броя на съзласните звуци

        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            int sum = 0;
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') { //ако имаме празно място пропускаме всичко на долу и не го броим
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') { //проверка за гласна буква
                    vowelIsCount++;
                } else if (currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?') { //проверка за пунктуационните знак
                    punctCount++;
                } else { //съгласна буква
                    consonantsCount++;
                }
            }
        }
        //знаем броя на символите във всяка категория
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_tack_4.txt"));
        writer.write("Vowels: " + vowelIsCount);
        writer.newLine();
        writer.write("Other symbols: " + consonantsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctCount);
        writer.close();
    }
}
