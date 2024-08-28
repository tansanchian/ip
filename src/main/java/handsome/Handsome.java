package handsome;

import handsome.command.Command;
import handsome.exception.HandsomeException;

import java.io.IOException;

public class Handsome {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Handsome() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.load());
    }

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
            } catch (IOException ioException){
                ui.showError("IO Error: " + ioException.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Handsome().run();
    }
}
