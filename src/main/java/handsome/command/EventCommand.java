package handsome.command;

import java.io.IOException;
import java.util.regex.PatternSyntaxException;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;
import handsome.exception.InvalidTaskException;
import handsome.task.Event;

public class EventCommand extends Command {
    private final String description;
    private final String start;
    private final String end;

    public EventCommand(String input) throws InvalidTaskException {
        try {
            String[] temp = input.split("/from");
            if (temp[0].substring(6).trim().isEmpty()) {
                throw new InvalidTaskException("You need provide task description for event. "
                        + "Type prompt to check the correct command.");
            }
            description = temp[0].substring(6).trim();
            start = temp[1].split("/to")[0].trim();
            end = temp[1].split("/to")[1].trim();
        } catch (PatternSyntaxException | ArrayIndexOutOfBoundsException error) {
            throw new InvalidTaskException("Invalid format for event! Type prompt to check the correct command.");
        }
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        tasks.add(new Event(description, "[ ]", start, end, false));
        storage.writeToFile(tasks);
        ui.showTaskText(tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
