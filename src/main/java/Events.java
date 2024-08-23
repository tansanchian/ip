public class Events extends Task{
    private final String startTime;
    private final String endTime;
    public Events(String content, String isDone, String startTime, String endTime) {
        super(content, isDone);
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + startTime + " to: " + endTime +")";
    }
}
