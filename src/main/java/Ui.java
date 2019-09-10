import java.util.Scanner;

public class Ui {

    public static void sayHi () {
        System.out.println(" ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
        System.out.println("Hello! I'm Duke \n"
                + "What can I do for you?");
    }

    public static void sayBye () {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static String readIn () {
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        return myString;
    }
}
