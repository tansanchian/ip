package handsome;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void greet() {
        System.out.println("""
                Hello! I'm Handsome
                What can I do for you?""");
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("___________________________________________________");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showByeText() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showMarkText(int index, TaskList tasks) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.getStringOfIndex(index));
    }

    public void showUnmarkText(int index, TaskList tasks) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.getStringOfIndex(index));
    }

    public void showDeleteText(int index, TaskList tasks) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.getStringOfIndex(index));
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }

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

    public void showTaskText(TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.getStringOfIndex(tasks.getSize() - 1));
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }
}
