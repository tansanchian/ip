public class ToDos extends Task {
    public ToDos(String content, String isDone) {
        super(content, isDone);
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
