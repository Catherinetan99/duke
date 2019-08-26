import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
        String[] list = new String[100];
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        for (int i = 0; !myString.equals("bye"); i+=0) {
            if (myString.equals("list")) {
                for (int j = 0; j < i; j++) {
                    System.out.println((j+1) + ". " + list[j]);
                }
            } else {
                list[i] = myString;
                System.out.println("added: " + myString);
                i++;
            }
            myInput = new Scanner(System.in); // Create a scanner object
            myString = myInput.nextLine(); // Read user input
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
