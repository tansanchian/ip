package handsome;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Storage class manages the reading and writing of task data
 * to and from a file in the Handsome chatBot application.
 * This class handles file creation, loading, and updating to ensure
 * task data is persisted between sessions.
 */
public class Storage {
    private final File handsomeList;

    /**
     * Constructs a new Storage object, initializing the storage
     * file and its containing directory if they do not already exist.
     * The constructor checks for the existence of the "./data" directory
     * and the "handsome.txt" file. If they are missing, it creates them.
     */
    public Storage() {
        createDirectory();
        handsomeList = createFile();
    }

    private void createDirectory() {
        File directory = new File("./data");
        if (!directory.exists()) {
            boolean isDirectoryCreated = directory.mkdir();
            assert isDirectoryCreated : "Failed to create directory: ./data";
        }
    }

    private File createFile() {
        File file = new File("./data/handsome.txt");
        if (!file.exists()) {
            try {
                boolean isFileCreated = file.createNewFile();
                assert isFileCreated : "Failed to create file: " + "./data/handsome.txt";
            } catch (IOException ioException) {
                System.out.println("IO ERROR while creating file " + "./data/handsome.txt" + ": "
                        + ioException.getMessage());
            }
        }
        return file;
    }

    /**
     * Loads and returns the task file used by the Handsome chatBot.
     * @return The File object representing the task data file.
     */
    public File load() {
        return handsomeList;
    }

    /**
     * Writes the current tasks from the TaskList to the storage file.
     * This method overwrites the file with the updated task list data,
     * saving the current state of tasks.
     *
     * @param tasks The TaskList containing the tasks to be written to the file.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public void writeToFile(TaskList tasks) throws IOException {
        FileWriter fileWriter = new FileWriter("./data/handsome.txt");
        fileWriter.write(tasks.toString());
        fileWriter.close();
    }
}
