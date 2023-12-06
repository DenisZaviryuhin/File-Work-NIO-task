package app.servise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class FileReadService {
   public String readFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException exception) {
            return "Error! " + exception.getMessage();
        }


    }
}
