package handsome;

import java.util.ArrayList;
import java.util.Scanner;

import handsome.task.Task;

/**
 * The Ui class handles user interaction with the Handsome chatBot.
 * It manages input reading and displays various messages to the user, including
 * greetings, errors, and task updates.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new Ui object, initializing the scanner
     * to read user input from the console.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Greets the user when the Handsome chatBot starts.
     */
    public void greet() {
        System.out.println("""
                Hello! I'm Handsome
                What can I do for you?""");
    }

    /**
     * Reads and returns user input from the console.
     *
     * @return The string input entered by the user.
     */
    public String readInput() {
        return scanner.nextLine();
    }

    /**
     * Displays a horizontal line separator for visual clarity in the console.
     */
    public void showLine() {
        System.out.println("___________________________________________________");
    }

    /**
     * Displays an error message to the user.
     *
     * @param errorMessage The error message to be shown.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Displays a goodbye message when the user exits the chatBot.
     */
    public void showByeText() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Displays a message indicating that the task at the specified index has been marked as done.
     *
     * @param index The index of the task that was marked as done.
     * @param tasks The TaskList containing the tasks.
     */
    public void showMarkText(int index, TaskList tasks) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.getStringOfIndex(index));
    }

    /**
     * Displays a message indicating that the task at the specified index has been marked as not done.
     *
     * @param index The index of the task that was marked as not done.
     * @param tasks The TaskList containing the tasks.
     */
    public void showUnmarkText(int index, TaskList tasks) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.getStringOfIndex(index));
    }

    /**
     * Displays a message indicating that the task at the specified index has been deleted.
     *
     * @param index The index of the task that was deleted.
     * @param tasks The TaskList containing the tasks.
     */
    public void showDeleteText(int index, TaskList tasks) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.getStringOfIndex(index));
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }

    /**
     * Displays all tasks currently in the task list.
     * If there are no tasks, an appropriate message is displayed instead.
     *
     * @param tasks The TaskList containing the tasks to be displayed.
     */
    public void showList(TaskList tasks) {
        if (tasks.getSize() == 0) {
            System.out.println("There is currently nothing in your list!");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            int count = i + 1;
            System.out.println(count + "." + tasks.getStringOfIndex(i));
        }
    }

    /**
     * Displays the list of available commands that the user can use.
     */
    public void showPrompt() {
        System.out.println("1. todo <description>: Add a todo task\n"
                + "2. deadline <description> /by <date> (date format: yyyy-mm-dd <time in 24 hr format>)"
                + ": Add a deadline task\n"
                + "3. event <description> /from <date> /to <date> (date format: yyyy-mm-dd <time in 24 hr format>)"
                + ": Add an event task\n"
                + "4. mark <task index>: Mark <index> task as done\n"
                + "5. unmark <task index>: Mark <index> task as not done\n"
                + "6. delete <task index>: Delete <index> task from tasks list"
                + "7. list: Show the current tasks list\n"
                + "8. prompt: Show the available commands\n"
                + "9. bye : Exit and close the chat bot");
    }

    /**
     * Displays a message indicating that a new task has been added to the list.
     *
     * @param tasks The TaskList containing the tasks, including the newly added task.
     */
    public void showTaskText(TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.getStringOfIndex(tasks.getSize() - 1));
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }

    /**
     * Displays the tasks that match a specified keyword to the user.
     * If there are no matching tasks, an appropriate message is displayed. Otherwise,
     * the matching tasks are listed with their corresponding indices.
     *
     * @param tasks An {@code ArrayList<Task>} containing the tasks that match the search keyword.
     */
    public void showMatchingTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no matching tasks in your list!");
            return;
        }
        System.out.println("Here are the matching tasks in your list:");
        int i = 1;
        for (Task t : tasks) {
            System.out.println(i + "." + t.toString());
        }
    }
}
