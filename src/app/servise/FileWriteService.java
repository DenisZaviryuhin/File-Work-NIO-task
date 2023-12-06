package app.servise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileAlreadyExistsException;

public class FileWriteService {
    public String createFile(String filePath) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(filePath));
        } catch (FileAlreadyExistsException fae) {
            return "File is already exist.";

        } catch (IOException exception) {
            return "Error!" + exception.getMessage();
        }
        return newFile + " is created";


    }

    public String writeFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException exception) {
            return exception.getMessage();

        }
        return "Recorded in " + path;

    }
}
