package handsome.command;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;
import handsome.exception.InvalidTaskException;
import handsome.task.Deadline;

import java.io.IOException;

public class DeadlineCommand extends Command {
    private final String description;
    private final String deadline;

    public DeadlineCommand(String input) throws InvalidTaskException {
        try {
            String[] temp = input.split("/by");
            if (temp[0].substring(9).trim().isEmpty()) {
                throw new InvalidTaskException("You need provide task description for deadline. "
                        + "Type prompt to check the correct command.");
            }
            description = temp[0].substring(9).trim();
            deadline = temp[1].trim();
        } catch (ArrayIndexOutOfBoundsException error) {
            throw new InvalidTaskException("Invalid format for deadline! Type prompt to check the correct command.");
        }
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        tasks.add(new Deadline(description, "[ ]", deadline, false));
        storage.writeToFile(tasks);
        ui.showTaskText(tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
