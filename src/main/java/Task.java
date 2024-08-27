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
}
