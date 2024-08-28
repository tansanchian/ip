package handsome.command;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;

import java.io.IOException;

public class UnmarkCommand extends Command {
    private final String input;

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
