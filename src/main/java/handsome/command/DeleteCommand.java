package handsome.command;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;

import java.io.IOException;

public class DeleteCommand extends Command {
    private final String input;

    public DeleteCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException {
        int index = toNumber(input.substring(7), tasks.getSize()) - 1;
        tasks.remove(index);
        storage.writeToFile(tasks);
        ui.showDeleteText(index, tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
