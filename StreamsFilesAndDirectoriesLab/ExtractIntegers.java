package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String inPath = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inPath));
        PrintWriter myFileOutput = new PrintWriter(new FileOutputStream(outPath));
        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int myNumber = scanner.nextInt();
                //System.out.println(scanner.nextInt());
                myFileOutput.println(myNumber);
            }
            scanner.next();
        }
        myFileOutput.close();
    }
}
