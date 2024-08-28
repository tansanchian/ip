package handsome.command;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        ui.showByeText();
    };

    @Override
    public boolean isExit() {
        return true;
    };
}
