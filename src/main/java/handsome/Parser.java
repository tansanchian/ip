package handsome;

import handsome.command.ByeCommand;
import handsome.command.Command;
import handsome.command.DeadlineCommand;
import handsome.command.DeleteCommand;
import handsome.command.EventCommand;
import handsome.command.ListCommand;
import handsome.command.MarkCommand;
import handsome.command.PromptCommand;
import handsome.command.TodoCommand;
import handsome.command.UnmarkCommand;
import handsome.exception.HandsomeException;
import handsome.exception.InvalidSyntaxException;

public class Parser {
    public static Command parse(String input) throws HandsomeException {
        if (input.equals("bye")) {
            return new ByeCommand();
        } else if (input.equals("prompt")) {
            return new PromptCommand();
        } else if (input.startsWith("mark ")) {
            return new MarkCommand(input);
        } else if (input.startsWith("delete ")) {
            return new DeleteCommand(input);
        } else if (input.startsWith("unmark ")) {
            return new UnmarkCommand(input);
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.startsWith("deadline ")) {
            return new DeadlineCommand(input);
        } else if (input.startsWith("event ")) {
            return new EventCommand(input);
        } else if (input.startsWith("todo ")) {
            return new TodoCommand(input);
        } else {
            throw new InvalidSyntaxException();
        }
    }
}
