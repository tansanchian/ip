import java.util.Scanner;

public class Handsome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Handsome\n" + "What can I do for you?\n");
        String input = scanner.nextLine();
        while (true) {
            if (input.equals("greet")) {
                System.out.println("Hello! I'm Handsome\n" + "What can I do for you?");
                input = scanner.nextLine();
            } else if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(input);
                input = scanner.nextLine();
            }
        }
    }
}
