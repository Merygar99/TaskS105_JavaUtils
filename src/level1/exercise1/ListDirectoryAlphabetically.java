package level1.exercise1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ListDirectoryAlphabetically {
    public static void listDirectory(String directoryPath) {
       File directory = new File(directoryPath);

          if (directory.exists() && directory.isDirectory()) {
              File[] files = directory.listFiles();

             if (files != null && files.length > 0) {
                  Arrays.sort(files, Comparator.comparing(File::getName));
                  System.out.println("Directory content: ");
                   for (File file : files) {
                        System.out.println(file.getName());
                        }
             } else {
                    System.out.println("The directory is empty.");
                }
          } else {
              System.out.println("The path is not a valid directory.");
            }
    }
}

