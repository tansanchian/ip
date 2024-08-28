import java.io.IOException;

public class UnmarkCommand extends Command {
    private String input;

    public UnmarkCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        int index = toNumber(input.substring(7), tasks.getSize()) - 1;
        tasks.markUndone(index);
        storage.writeToFile(tasks);
        ui.showUnmarkText(index, tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
