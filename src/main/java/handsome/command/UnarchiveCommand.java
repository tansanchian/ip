package handsome.command;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;

/**
 * Represents a command to unarchive all tasks.
 */
public class UnarchiveCommand extends Command {
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        tasks.unarchiveTasks();
        return ui.showUnarchiveText();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
