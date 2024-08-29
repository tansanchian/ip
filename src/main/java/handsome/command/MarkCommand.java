package handsome.command;

import java.io.IOException;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;

public class MarkCommand extends Command {
    private final String input;

    public MarkCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        int index = toNumber(input.substring(5), tasks.getSize()) - 1;
        tasks.markDone(index);
        storage.writeToFile(tasks);
        ui.showMarkText(index, tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
