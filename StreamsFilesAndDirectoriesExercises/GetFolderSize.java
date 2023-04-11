package StreamsFilesAndDirectories.Exersises;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        //достъп до папката
        //обхождаме всички файлове в папката -> взимаме размера на всеки файл и го сумираме
        //печатаме общия размер на папката
        String path = "D:\\Documents\\Projects\\Advanced-January\\src\\StreamsFilesAndDirectories\\Exersises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
