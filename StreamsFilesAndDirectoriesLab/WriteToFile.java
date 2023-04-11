package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String pathIn = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');

        try(FileInputStream in = new FileInputStream(pathIn);
            FileOutputStream out = new FileOutputStream(pathOut)){
            int oneByte = in.read();
            while (oneByte >= 0){
                char myByteAsChar = (char)oneByte;
                if(!forbiddenSymbols.contains(myByteAsChar)){
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        }catch (IOException e){

        }
    }
}
