package level1.exercise2;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\usuario\\IdeaProjects\\TaskS105");

        ShowDirectoryContent.showDirectory(file, 1);
    }
}
