package handsome;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import handsome.task.ToDo;
import handsome.exception.InvalidTaskException;
import handsome.task.Deadline;
import handsome.task.Event;
import handsome.task.Task;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(File file) {
        try {
            Scanner handsomeScanner = new Scanner(file);
            while (handsomeScanner.hasNext()) {
                String[] task = handsomeScanner.nextLine().split(" \\| ");
                String type = task[0];
                String isDone = task[1];
                switch (type) {
                case "T":
                    tasks.add(new ToDo(task[2], isDone));
                    break;
                case "D":
                    tasks.add(new Deadline(task[2], isDone, task[3], true));
                    break;
                case "E":
                    tasks.add(new Event(task[2], isDone, task[3], task[4], true));
                    break;
                default:
                    throw new InvalidTaskException("Error Loading");
                }
            }
        } catch (FileNotFoundException fileError) {
            System.out.println("File not found!");
        } catch (ArrayIndexOutOfBoundsException | InvalidTaskException error) {
            System.out.println("Data file corrupted!");
        }
    }

    public int getSize() {
        return tasks.size();
    }

    public void markDone(int index) {
        tasks.get(index).markDone();
    }

    public void markUndone(int index) {
        tasks.get(index).markUndone();
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public String getStringOfIndex(int index) {
        return tasks.get(index).toString();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Searches the task list for tasks that contain the specified keyword in their content.
     *
     * @param keyword The keyword to search for within the tasks.
     * @return An {@code ArrayList<Task>} containing tasks that match the specified keyword.
     */
    public ArrayList<Task> findKeyword(String keyword) {
        ArrayList<Task> ans = new ArrayList<>();
        for (Task t : tasks) {
            if (t.contains(keyword)) {
                ans.add(t);
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Task t : tasks) {
            String curr = t.toDataFormat() + System.lineSeparator();
            data.append(curr);
        }
        return data.toString();
    }
}