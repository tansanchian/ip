package handsome.command;

import java.io.IOException;

import handsome.Storage;
import handsome.TaskList;
import handsome.Ui;
import handsome.exception.HandsomeException;
import handsome.exception.InvalidSyntaxException;
import handsome.exception.ListIndexOutOfBoundException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException, IOException;

    public abstract boolean isExit();

    public int toNumber(String string, int size) throws ListIndexOutOfBoundException, InvalidSyntaxException {
        if (string == null || string.isEmpty()) {
            throw new InvalidSyntaxException();
        }
        try {
            int intValue = Integer.parseInt(string);
            if (intValue > size || intValue <= 0) {
                throw new ListIndexOutOfBoundException(size);
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new InvalidSyntaxException();
        }
    }
}
