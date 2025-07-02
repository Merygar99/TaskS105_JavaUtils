package level1.exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SaveFilesTxt {

    public static void showDirectory(File directory, int level) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    printFile(file, level);
                }
            }
        }
    }

    private static void printFile(File file, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        String type = file.isDirectory() ? "D" : "F";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastModified = sdf.format(new Date(file.lastModified()));

        System.out.println(indent.toString() + type + " " + file.getName() + " (" + lastModified + ")");

        saveDirectoryList("C:\\Users\\usuario\\IdeaProjects\\TaskS105\\src\\DirectoryTree.txt"
                , indent.toString() + type + " " + file.getName() + " (" + lastModified + ")\n");

        if (file.isDirectory()) {
            showDirectory(file, level + 1);
        }
    }

    public static void saveDirectoryList(String filePath, String directory) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(directory);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
