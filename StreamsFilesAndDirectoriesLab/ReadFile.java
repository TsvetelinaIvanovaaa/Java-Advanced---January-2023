package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }

    }
}

