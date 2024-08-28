import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File handsome;

    public Storage() {
        try {
            File directory = new File("./data");
            if (!directory.exists()) {
                if (!directory.mkdir()) {
                    System.out.println("Failed to create directory!");
                }
            }
           handsome = new File("./data/handsome.txt");
            if (!handsome.exists()) {
                if (!handsome.createNewFile()) {
                    System.out.println("File already exists but was not found earlier!");
                }
            }
        } catch (IOException ioException) {
            System.out.println("IO ERROR: " + ioException.getMessage());
        }
    }

    public File load() {
        return handsome;
    }

    public void writeToFile(TaskList tasks) throws IOException {
        FileWriter fileWriter = new FileWriter("./data/handsome.txt");
        fileWriter.write(tasks.toString());
        fileWriter.close();
    }
}
