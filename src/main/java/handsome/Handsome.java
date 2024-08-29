package handsome;

import java.io.IOException;

import handsome.command.Command;
import handsome.exception.HandsomeException;

/**
 * Represents the main chatBot application named Handsome, which operates
 * based on Object-Oriented Programming principles. The Handsome class is
 * responsible for managing user interactions, loading tasks, and executing
 * commands.
 */
public class Handsome {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a new Handsome chatBot with initialized storage, task list,
     * and user interface.
     * The chatBot loads existing tasks from storage upon initialization.
     */
    public Handsome() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the main loop of the Handsome chatBot, greeting the user and
     * processing input commands until the user exits.
     * The method handles user input, command execution, and error handling
     * throughout the interaction.
     */
    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readInput();
                ui.showLine();
                Command command = Parser.parse(input);
                command.execute(tasks, storage, ui);
                isExit = command.isExit();
            } catch (HandsomeException error) {
                ui.showError(error.getMessage());
            } catch (IOException ioException) {
                ui.showError("IO Error: " + ioException.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main entry point for the Handsome chatBot application.
     */
    public static void main(String[] args) {
        new Handsome().run();
    }
}
