package handsome.task;

import handsome.exception.InvalidTaskException;

import java.time.DateTimeException;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String content, String isDone, String deadline, boolean isFormatted) throws InvalidTaskException {
        super(content, isDone);
        if (isFormatted) {
            this.deadline = deadline;
        } else {
            try {
                this.deadline = formatDate(deadline);
            } catch (DateTimeException error) {
                throw new InvalidTaskException("Date and time must be formatted correctly for deadline! "
                        + "Type prompt to check the correct date format");
            }
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + deadline + ")";
    }

    @Override
    public String toDataFormat() {
        return "D | " + super.toDataFormat() + " | " + deadline;
    }
}
