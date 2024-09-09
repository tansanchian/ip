package handsome.task;

/**
 * The ToDo class represents a basic task in the Handsome chatBot
 * application without any specific date or time constraints. It extends
 * the Task class and adds a simple label indicating the task type.
 */
public class ToDo extends Task {
    private boolean isArchived = false;
    /**
     * Constructs a ToDo task with the specified content and status.
     *
     * @param content The description of the ToDo task.
     * @param isDone  The status of the task, indicating whether it is done or not.
     */
    public ToDo(String content, String isDone) {
        super(content, isDone);
    }
    @Override
    public boolean isArchived() {
        return isArchived;
    }

    @Override
    public void archive() {
        isArchived = true;
    }

    @Override
    public void unarchive() {
        isArchived = false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toDataFormat() {
        return "T | " + super.toDataFormat();
    }
}
