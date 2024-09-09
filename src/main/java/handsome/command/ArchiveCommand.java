package handsome.command;

import java.io.IOException;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;

/**
 * Represents a command to archive all tasks.
 */
public class ArchiveCommand extends Command {
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) throws IOException {
        tasks.archiveTasks();
        return ui.showArchiveText();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
