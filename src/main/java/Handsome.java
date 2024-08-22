import java.util.Scanner;

public class Handsome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Handsome\n" + "What can I do for you?\n");
        String[] list = new String[100];
        int currSize = 0;
        String input = scanner.nextLine();
        while (true) {
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < currSize; i++) {
                    int count = i + 1;
                    System.out.println(count + ": " + list[i]);
                }
                input = scanner.nextLine();
            } else {
                System.out.println("added: " + input);
                list[currSize] = input;
                currSize++;
                input = scanner.nextLine();
            }
        }
    }
}
