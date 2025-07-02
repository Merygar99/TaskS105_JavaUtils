package level2.exercise1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectoryLister {
    private final File rootDirectory;
    private final File outputFile;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DirectoryLister(String rootDir, String outputFilePath) {
        this.rootDirectory = new File(rootDir);
        this.outputFile = new File(outputFilePath);
    }

    public void listAndSave() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            listDirectoryRecursive(rootDirectory, writer, 0);
        }
    }

    private void listDirectoryRecursive(File dir, BufferedWriter writer, int indentLevel) throws IOException {
        if (!dir.exists()) return;

        File[] files = dir.listFiles();
        if (files == null) return;

        Arrays.sort(files, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

        for (File file : files) {
            String indent = "  ".repeat(indentLevel);
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = dateFormat.format(new Date(file.lastModified()));
            writer.write(String.format("%s[%s] %s (Last Modified: %s)", indent, type, file.getName(), lastModified));
            writer.newLine();

            if (file.isDirectory()) {
                listDirectoryRecursive(file, writer, indentLevel + 1);
            }
        }
    }
}
