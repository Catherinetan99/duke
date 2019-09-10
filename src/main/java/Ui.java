import java.util.Scanner;

public class Ui {

    /**
     * Prints out welcome statement
     */
    public static void sayHi () {
        System.out.println(" ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
        System.out.println("Hello! I'm Duke \n"
                + "What can I do for you?");
    }

    /**
     * Prints out bye statement
     */
    public static void sayBye () {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Reads in user input and returns user input
     * @return String input by user
     */
    public static String readIn () {
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        return myString;
    }
}
