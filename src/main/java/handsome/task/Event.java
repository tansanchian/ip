package handsome.task;

import handsome.exception.InvalidTaskException;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final String startTime;
    private final String endTime;

    public Event(String content, String isDone, String startTime, String endTime, boolean isFormatted) throws InvalidTaskException {
        super(content, isDone);
        if (isFormatted) {
            this.startTime = startTime;
            this.endTime = endTime;
        } else {
            try {
                this.startTime = formatDate(startTime);
                this.endTime = formatDate(endTime);
                if (LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")).
                        isAfter(LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")))) {
                    throw new InvalidTaskException("End time of event must be later than start time!");
                }
            } catch (DateTimeException dateTimeException) {
                throw new InvalidTaskException("Date and time must be formatted correctly for event! Type prompt to check the "
                        + "correct date format");
            }
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + startTime + " to: " + endTime +")";
    }

    @Override
    public String toDataFormat() {
        return "E | " + super.toDataFormat() + " | " + startTime + " | " + endTime;
    }
}
