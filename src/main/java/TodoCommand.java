import java.io.IOException;

public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String input) {
        description = input.substring(5);
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        tasks.add(new ToDo(description, "[ ]"));
        storage.writeToFile(tasks);
        ui.showTaskText(tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
