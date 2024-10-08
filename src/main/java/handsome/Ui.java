package handsome;

import java.util.ArrayList;

import handsome.task.Task;

/**
 * The Ui class handles user interaction with the Handsome chatBot.
 * It manages input reading and displays various messages to the user, including
 * greetings, errors, and task updates.
 */
public class Ui {
    /**
     * Displays an error message to the user.
     *
     * @param errorMessage The error message to be shown.
     */
    public String showError(String errorMessage) {
        System.out.println(errorMessage);
        return errorMessage;
    }

    /**
     * Displays a goodbye message when the user exits the chatBot.
     */
    public String showByeText() {
        String byeText = "Bye. Hope to see you again soon!";
        System.out.println(byeText);
        return byeText;
    }

    /**
     * Displays a message indicating that the task at the specified index has been marked as done.
     *
     * @param index The index of the task that was marked as done.
     * @param tasks The TaskList containing the tasks.
     */
    public String showMarkText(int index, TaskList tasks) {
        String task = tasks.getStringOfIndex(index);
        String markedTask = "Nice! I've marked this task as done:\n" + task;
        System.out.println(markedTask);
        return markedTask;
    }

    /**
     * Displays a message indicating that the task at the specified index has been marked as not done.
     *
     * @param index The index of the task that was marked as not done.
     * @param tasks The TaskList containing the tasks.
     */
    public String showUnmarkText(int index, TaskList tasks) {
        String task = tasks.getStringOfIndex(index);
        String unmarkedTask = "OK, I've marked this task as not done yet:\n" + task;
        System.out.println(unmarkedTask);
        return unmarkedTask;
    }

    /**
     * Displays a message indicating that the task at the specified index has been deleted.
     *
     * @param task The task that was deleted.
     */
    public String showDeleteText(Task task) {
        String deletedTask = "Noted. I've removed this task:\n" + task;
        System.out.println(deletedTask);
        return deletedTask;
    }

    /**
     * Displays all tasks currently in the task list.
     * If there are no tasks, an appropriate message is displayed instead.
     *
     * @param tasks The TaskList containing the tasks to be displayed.
     */
    public String showList(TaskList tasks) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = 1;
        for (int i = 0; i < tasks.getSize(); i++) {
            if (!tasks.isArchived(i)) {
                stringBuilder.append(j).append(".").append(tasks.getStringOfIndex(i)).append("\n");
                j++;
            }
        }
        if (tasks.getSize() == 0 || j == 1) {
            String emptyListText = "There is currently nothing in your list!";
            System.out.println(emptyListText);
            return emptyListText;
        }
        System.out.println("Here are the tasks in your list:\n" + stringBuilder);
        return "Here are the tasks in your list:\n" + stringBuilder;
    }

    /**
     * Displays the list of available commands that the user can use.
     */
    public String showPrompt() {
        String prompt = "1. todo <description>: Add a todo task\n"
                + "2. deadline <description> /by <date> (date format: yyyy-mm-dd <time in 24 hr format>)"
                + ": Add a deadline task\n"
                + "3. event <description> /from <date> /to <date> (date format: yyyy-mm-dd <time in 24 hr format>)"
                + ": Add an event task\n"
                + "4. mark <task index>: Mark <index> task as done\n"
                + "5. unmark <task index>: Mark <index> task as not done\n"
                + "6. delete <task index>: Delete <index> task from tasks list\n"
                + "7. list: Show the current tasks list\n"
                + "8. prompt: Show the available commands\n"
                + "9. bye : Exit and close the chat bot\n"
                + "10. archive: Archive the task list\n"
                + "11. unarchive: Unarchive the task list";
        System.out.println(prompt);
        return prompt;
    }

    /**
     * Displays a message indicating that a new task has been added to the list.
     *
     * @param tasks The TaskList containing the tasks, including the newly added task.
     */
    public String showTaskText(TaskList tasks) {
        int size = tasks.getSize();
        String task = tasks.getStringOfIndex(size - 1);
        String tasksText = "Got it. I've added this task:\n" + task
                + "\n\"Now you have " + size + " tasks in the list. (included archived tasks)";
        System.out.println(tasksText);
        return tasksText;
    }

    /**
     * Displays the tasks that match a specified keyword to the user.
     * If there are no matching tasks, an appropriate message is displayed. Otherwise,
     * the matching tasks are listed with their corresponding indices.
     *
     * @param tasks An {@code ArrayList<Task>} containing the tasks that match the search keyword.
     */
    public String showMatchingTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            String noMatchingString = "There are no matching tasks in your list!";
            System.out.println(noMatchingString);
            return noMatchingString;
        }
        StringBuilder stringBuilder = new StringBuilder("Here are the matching tasks in your list:\n");
        int i = 1;
        for (Task t : tasks) {
            stringBuilder.append(i).append(".").append(t.toString()).append("\n");
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * Displays a message indicating tha the task list has been archived.
     */
    public String showArchiveText() {
        String archiveText = "Task List is successfully archived!";
        System.out.println(archiveText);
        return archiveText;
    }

    /**
     * Displays a message indicating tha the task list has been unarchived.
     */
    public String showUnarchiveText() {
        String unarchiveText = "Task List is successfully unarchived!";
        System.out.println(unarchiveText);
        return unarchiveText;
    }
}
