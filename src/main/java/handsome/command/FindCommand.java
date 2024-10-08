package handsome.command;

import java.util.ArrayList;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.task.Task;

/**
 * The FindCommand class handles the "find" command, which searches
 * for tasks in the Handsome chatBot's task list that match a specified keyword.
 */
public class FindCommand extends Command {
    private final String input;

    /**
     * Constructs a FindCommand object by storing the user input that specifies
     * the keyword to search for within the task list.
     *
     * @param input The input string containing the "find" command and the search keyword.
     */
    public FindCommand(String input) {
        this.input = input;
    }

    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        String keyword = input.substring(5);
        ArrayList<Task> matchedTasks = tasks.findKeyword(keyword);
        return ui.showMatchingTasks(matchedTasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
