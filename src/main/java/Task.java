import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

public abstract class Task {
    public Task(String content, String isDone) {
        this.content = content;
        this.isDone = isDone;
    }
    private final String content;
    private String isDone;

    public void markDone() {
        this.isDone = "[X]";
    }

    public void markUndone() {
        this.isDone = "[ ]";
    }
    @Override
    public String toString() {
        return isDone + " " + content;
    }
    public String toDataFormat() {
        return isDone + " | " + content;
    };
    public String formatDate(String date) throws InvalidTaskException {
        try {
            String[] dateAndTime = date.split(" ");
            LocalDate d = LocalDate.parse(dateAndTime[0]);
            LocalTime t = LocalTime.parse(dateAndTime[1], DateTimeFormatter.ofPattern("HHmm"));
            return d.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + ", " + d.getDayOfMonth() + " "
                    + d.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + d.getYear() + ", "
                    + t.format(DateTimeFormatter.ofPattern("hh:mm a"));
        } catch (DateTimeException dateTimeException) {
            throw new InvalidTaskException("Invalid format!\n"
                    + "Format for deadline: <NAME> /by yyyy-mm-dd <time in 24 hr format>\n"
                    + "Format for event: <NAME> /from yyyy-mm-dd <time in 24 hr format> "
                    + "/to yyyy-mm-dd <time in 24 hr format");
        }
    }
}
