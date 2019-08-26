import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
        List<Task> tasks = new ArrayList<Task>();
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        for (int i = 0; !myString.equals("bye"); i+=0) {
            if (myString.equals("list")) {
                System.out.println("Here are the tasks in your list: ");
                for (int j = 0; j < i; j++) {
                    Task task = tasks.get(j);
                    System.out.println((j + 1) + ".[" + task.getStatusIcon() + "]" + task.description);
                }
            } else if (myString.length() > 4 && myString.substring(0, 4).equals("done")) {
                int taskNumber = Integer.parseInt(myString.substring(5));
                Task task = tasks.get(taskNumber-1);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("  ["+ "\u2713" + "] " + task.description);
            } else {
                Task task = new Task(myString);
                tasks.add(task);
                System.out.println("added: " + myString);
                i++;
            }
            myInput = new Scanner(System.in); // Create a scanner object
            myString = myInput.nextLine(); // Read user input
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
