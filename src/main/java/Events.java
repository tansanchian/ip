public class Events extends Task {
    private final String startTime;
    private final String endTime;
    public Events(String content, String isDone, String startTime, String endTime) throws InvalidTaskException {
        super(content, isDone);
        this.startTime = formatDate(startTime);
        this.endTime = formatDate(endTime);
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + startTime + " to: " + endTime +")";
    }
    @Override
    public String toDataFormat() {
        return "T | " + super.toDataFormat() + " | " + startTime + " | " + endTime;
    }
}
