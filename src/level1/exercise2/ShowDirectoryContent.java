package level1.exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShowDirectoryContent {
    public static void showDirectory(File directory, int level) {
        if (directory == null || !directory.isDirectory() || !directory.isDirectory()) {
            System.out.println("Invalid or inaccessible directory: " + directory);
            return;
        }

            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    printFile(file, level);
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

        if (file.isDirectory()) {
            showDirectory(file, level + 1);
        }
    }
}




