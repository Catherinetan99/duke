import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Duke {
    private static final String filePath = "C:\\Users\\Catherine Tan\\IdeaProjects\\duke.txt";
    private static int count = 0;
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
        ArrayList<Task> tasks = new ArrayList<>();
        DukeException errorMessage = new DukeException();
        Scanner myInput = new Scanner(System.in); // Create a scanner object
        String myString = myInput.nextLine(); // Read user input
        while (!myString.equals("bye")) {
            if (myString.equals("list")) {
                System.out.println("Here are the tasks in your list: ");
                for (int j = 0; j < count; j++) {
                    Task task = tasks.get(j);
                    System.out.println((j + 1)+ "." + task.toString());
                }
            } else if (myString.length() >= 4 && myString.substring(0, 4).equals("done")) {
                try {
                    int taskNumber = Integer.parseInt(myString.substring(5));
                    Task task = tasks.get(taskNumber - 1);
                    task.markAsDone();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("  " + task.toString());
                    updateFile(tasks);
                } catch (IndexOutOfBoundsException e) {
                    errorMessage.emptyTaskNo();
                }
            } else if (myString.length() >= 4 && myString.substring(0, 4).equals("todo")){
                try {
                    Todo todo = new Todo(myString.substring(5));
                    tasks.add(todo);
                    count++;
                    System.out.println("Got it. I've added this task:\n"
                            + todo.toString() + "\n"
                            + "Now you have " + count + " tasks in the list.");
                    updateFile(tasks);
                } catch (IndexOutOfBoundsException e) {
                    errorMessage.emptyDescription(myString.substring(0, 4));
                }
            } else if (myString.length() >=8 && myString.substring(0, 8).equals("deadline")) {
                try {
                    int j = 0;
                    while (!myString.substring(j, j + 1).equals("/")) {
                        j++;
                    }
                    try {
                        myString = myString.substring(0, j + 4) + formatDate(myString.substring(j + 4));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Deadline deadline = new Deadline(myString.substring(9, j), myString.substring(j + 4));
                    tasks.add(deadline);
                    count++;
                    System.out.println("Got it. I've added this task:\n"
                            + deadline.toString() + "\n"
                            + "Now you have " + count + " tasks in the list.");
                    updateFile(tasks);
                } catch (IndexOutOfBoundsException e) {
                    errorMessage.emptyDescription(myString.substring(0, 8));
                }
            } else if (myString.length() >= 5 && myString.substring(0, 5).equals("event")) { // event
                try {
                    int k = 0;
                    while (!myString.substring(k, k + 1).equals("/")) {
                        k++;
                    }
                    try {
                        myString = myString.substring(0, k + 4) + formatDate(myString.substring(k + 4));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Event event = new Event(myString.substring(6, k), myString.substring(k + 4));
                    tasks.add(event);
                    count++;
                    System.out.println("Got it. I've added this task:\n"
                            + event.toString() + "\n"
                            + "Now you have " + count + " tasks in the list.");
                    updateFile(tasks);
                } catch (IndexOutOfBoundsException e) {
                    errorMessage.emptyDescription(myString.substring(0, 5));
                }
            } else {
                errorMessage.invalidInput();
            }
            myInput = new Scanner(System.in); // Create a scanner object
            myString = myInput.nextLine(); // Read user input
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void updateFile (ArrayList<Task> tasks) {
        File f = new File(filePath);
        try {
            PrintWriter outputStream = new PrintWriter(f);
            for (int i = 0; i < count; i++) {
                Task task = tasks.get(i);
                outputStream.println(task.toString());
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String formatDate(String date) throws ParseException {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy HHmm");
        Date inputDate = new SimpleDateFormat("d/MM/yyyy HHmm").parse(date);
        String outputDate = null;
        outputDate = outputFormat.format(inputDate);
        if(outputDate.substring(0, 2).equals("11") || outputDate.substring(0, 2).equals("12") || outputDate.substring(0, 2).equals("13")) {
            outputDate = outputDate.substring(0,2) + "th of" + outputDate.substring(2);
        } else if (outputDate.substring(1, 2).equals("1")) {
            outputDate = outputDate.substring(0,2) + "st of" + outputDate.substring(2);
        } else if (outputDate.substring(1, 2).equals("2")) {
            outputDate = outputDate.substring(0,2) + "nd of" + outputDate.substring(2);
        } else if (outputDate.substring(1, 2).equals("3")) {
            outputDate = outputDate.substring(0,2) + "rd of" + outputDate.substring(2);
        } else {
            outputDate = outputDate.substring(0,2) + "th of" + outputDate.substring(2);
        }
        if (outputDate.substring(0, 1).equals("0")) {
            outputDate = outputDate.substring(1);
        }
        int size = outputDate.length();
        if (Integer.parseInt(outputDate.substring(size - 4, size - 2)) > 12) {
            String hour = "" + (Integer.parseInt(outputDate.substring(size - 4, size - 2)) - 12);
            outputDate = outputDate.substring(0, size - 4) + hour + "." +outputDate.substring(size - 2) + "pm";
        } else {
            outputDate = outputDate.substring(0, size - 2) + "." + outputDate.substring(size - 2) + "am";
            if (outputDate.substring(size - 4, size - 3).equals("0")) {
                outputDate = outputDate.substring(0, size - 4) + outputDate.substring(size - 3);
            }
        }
        return outputDate;
    }
}
