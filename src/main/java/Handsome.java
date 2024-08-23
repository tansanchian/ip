import java.util.ArrayList;
import java.util.Scanner;

public class Handsome {
    private static int toNumber(String string, int size) throws ListIndexOutOfBoundException {
        if (string == null || string.isEmpty()) {
            return -1;
        }
        try {
            int intValue = Integer.parseInt(string);
            if (intValue > size || intValue <= 0) {
                throw new ListIndexOutOfBoundException("Invalid List Index! List has " + size + " items.");
            }
            return intValue;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Handsome\n" + "What can I do for you?\n");
        ArrayList<Task> list = new ArrayList<>();
        int currSize = 0;
        String input = scanner.nextLine();
        while (true) {
            try {
                if (input.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (input.startsWith("mark ") && toNumber(input.substring(5), currSize) != -1) {
                    int index = toNumber(input.substring(5), currSize);
                    list.get(index - 1).markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(list.get(index - 1).toString());
                    input = scanner.nextLine();
                } else if (input.startsWith("delete ") && toNumber(input.substring(7), currSize) != -1) {
                    int index = toNumber(input.substring(7), currSize);
                    list.remove(index - 1);
                    currSize--;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(list.get(index - 1).toString());
                    System.out.println("Now you have " + currSize + " tasks in the list.");
                    input = scanner.nextLine();
                } else if (input.startsWith("unmark ") && toNumber(input.substring(7), currSize) != -1) {
                    int index = toNumber(input.substring(7), currSize);
                    list.get(index - 1).markUndone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(list.get(index - 1).toString());
                    input = scanner.nextLine();
                } else if (input.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < currSize; i++) {
                        int count = i + 1;
                        System.out.println(count + "." + list.get(i).toString());
                    }
                    input = scanner.nextLine();
                } else if (input.trim().equals("deadline") || input.trim().equals("todo") || input.trim().equals("event")) {
                    throw new InvalidTaskException("You need provide details for " + input);
                } else if (input.startsWith("deadline ")) {
                    if (!input.contains("/by")) {
                        throw new InvalidTaskException("You need provide the deadline for deadline! (format: deadline <NAME> /by <DEADLINE>");
                    } else {
                        String[] temp = input.split("/by");
                        if (temp[0].substring(9).trim().isEmpty()) {
                            throw new InvalidTaskException("You need provide task description for deadline");
                        }
                        list.add(new Deadlines(temp[0].substring(9), "[ ]", temp[1].trim()));
                        currSize++;
                        System.out.println("Got it. I've added this task:");
                        System.out.println(list.get(currSize - 1).toString());
                        System.out.println("Now you have " + currSize + " tasks in the list.");
                    }
                    input = scanner.nextLine();
                } else if (input.startsWith("event ")) {
                    if (!input.contains("/from") || !input.contains("/to")) {
                        throw new InvalidTaskException("You need provide start time and end time for event! (format: event <NAME> /from <START> /to <END>");
                    } else {
                        String[] temp = input.split("/from");
                        if (temp[0].substring(6).trim().isEmpty()) {
                            throw new InvalidTaskException("You need provide task description for event");
                        }
                        String start = temp[1].split("/to")[0].trim();
                        String end = temp[1].split("/to")[1].trim();
                        list.add(new Events(temp[0].substring(6), "[ ]", start, end));
                        currSize++;
                        System.out.println("Got it. I've added this task:");
                        System.out.println(list.get(currSize - 1).toString());
                        System.out.println("Now you have " + currSize + " tasks in the list.");
                    }
                    input = scanner.nextLine();
                } else if (input.startsWith("todo ")) {
                    list.add(new ToDos(input.substring(5), "[ ]"));
                    currSize++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println(list.get(currSize - 1).toString());
                    System.out.println("Now you have " + currSize + " tasks in the list.");
                    input = scanner.nextLine();
                } else {
                    throw new InvalidSytaxException("Invalid SYNTAX");
                }
            } catch (HandsomeException e) {
                System.out.println(e.getMessage());
                input = scanner.nextLine();
            }
        }
    }
}
