package handsome.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public abstract class Task {
    private final String content;
    private String isDone;

    public Task(String content, String isDone) {
        this.content = content;
        this.isDone = isDone;
    }

    public void markDone() {
        this.isDone = "[X]";
    }

    public void markUndone() {
        this.isDone = "[ ]";
    }

    @Override
    public String toString() {
        return isDone + " " + content + " ";
    }

    public String toDataFormat() {
        return isDone + " | " + content;
    };

    /**
     * Checks if the task's content contains the specified keyword.
     *
     * @param keyword The keyword to search for within the task's content.
     * @return true if the task's content contains the keyword, false otherwise.
     */
    public boolean contains(String keyword) {
        return content.contains(keyword);
    }

    public String formatDate(String date) {
        String[] dateAndTime = date.split(" ");
        LocalDate d = LocalDate.parse(dateAndTime[0]);
        LocalTime t = LocalTime.parse(dateAndTime[1], DateTimeFormatter.ofPattern("HHmm"));
        return d.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + ", " + d.getDayOfMonth() + " "
                + d.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + d.getYear() + ", "
                + t.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
}
