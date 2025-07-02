package level2.exercise1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\usuario\\IdeaProjects\\TaskS105\\src\\main\\resources\\config.properties")) {
            props.load(fis);

            String rootDir = props.getProperty("root.directory");
            String outputFile = props.getProperty("output.file");

            DirectoryLister lister = new DirectoryLister(rootDir, outputFile);
            lister.listAndSave();

            System.out.println("List of directories stored in: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

