import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        while (!myString.equals("bye")) {
            System.out.println(myString);
            myInput = new Scanner(System.in); // Create a scanner object
            myString = myInput.nextLine(); // Read user input
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
