package level1.exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class ReadFiles {

    public static void showFilesDirectory(File directory, int level) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    printFiles(file, level);
                }
            }
        }
    }

    private static void printFiles(File file, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        String type = file.isDirectory() ? "D" : "F";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastModified = sdf.format(new Date(file.lastModified()));

        System.out.println(indent.toString() + type + " " + file.getName() + " (" + lastModified + ")");

        if (file.isDirectory()) {
            showFilesDirectory(file, level + 1);
        }
    }

    public static void readFiles(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


}
