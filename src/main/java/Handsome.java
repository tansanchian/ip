import java.util.Scanner;

public class Handsome {
    private static int toNumber(String string, int size) {
        if (string == null || string.isEmpty()) {
            return -1;
        }
        try {
            int intValue = Integer.parseInt(string);
            if (intValue > size || intValue <= 0) {
                return -2;
            }
            return intValue;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Handsome\n" + "What can I do for you?\n");
        Task[] list = new Task[100];
        int currSize = 0;
        String input = scanner.nextLine();
        while (true) {
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (input.startsWith("mark ") && toNumber(input.substring(5), currSize) != -1) {
                int index = toNumber(input.substring(5), currSize);
                if (index == -2) {
                    System.out.println("Invalid index");
                } else {
                    list[index - 1].markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(" [X] " + list[index - 1].getContent());
                }
                input = scanner.nextLine();
            } else if (input.startsWith("unmark ") && toNumber(input.substring(7), currSize) != -1) {
                int index = toNumber(input.substring(7), currSize);
                if (index == -2) {
                    System.out.println("Invalid index");
                } else {
                    list[index - 1].markUndone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(" [ ] " + list[index - 1].getContent());
                }
                input = scanner.nextLine();
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < currSize; i++) {
                    int count = i + 1;
                    System.out.println(count + "." + list[i].getIsDone() + " " + list[i].getContent());
                }
                input = scanner.nextLine();
            } else {
                System.out.println("added: " + input);
                list[currSize] = new Task(input, "[ ]");
                currSize++;
                input = scanner.nextLine();
            }
        }
    }
}
