public class Deadlines extends Task{
    private final String deadline;
    public Deadlines(String content, String isDone, String deadline) {
        super(content, isDone);
        this.deadline = deadline;
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
