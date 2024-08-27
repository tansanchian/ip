public class Deadlines extends Task {
    private final String deadline;
    public Deadlines(String content, String isDone, String deadline) throws InvalidTaskException {
        super(content, isDone);
        this.deadline = formatDate(deadline);
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + deadline + ")";
    }
    @Override
    public String toDataFormat() {
        return "T | " + super.toDataFormat() + " | " + deadline;
    }
}
