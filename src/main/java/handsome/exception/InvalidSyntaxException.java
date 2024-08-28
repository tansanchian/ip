package handsome.exception;

public class InvalidSyntaxException extends HandsomeException {
    public InvalidSyntaxException() {
        super("Invalid Syntax! Type prompt to check for valid command");
    }
}
