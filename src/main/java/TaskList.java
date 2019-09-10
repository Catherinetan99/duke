import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskList {

    static ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public static ArrayList<Task> getTasks() { return tasks; }

    public static Task getSpecificTask(int index) {
        return tasks.get(index);
    }

    public static void addTask(String taskType, String description, TaskList taskList) {
        switch(taskType) {
            case "todo":
                try {
                    Todo todo = new Todo(description);
                    taskList.tasks.add(todo);
                    System.out.println("Got it. I've added this task:\n"
                            + todo.toString() + "\n"
                            + "Now you have " + taskList.tasks.size() + " tasks in the list.");
                } catch (IndexOutOfBoundsException e) {
                    DukeException errorMessage = new DukeException();
                    errorMessage.emptyDescription("todo");
                }
                break;
            case "deadline":
                try {
                    String[] split = description.split("\\/", 2);
                    try {
                        split[1] = formatDate(split[1].substring(3));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Deadline deadline = new Deadline(split[0], split[1]);
                    taskList.tasks.add(deadline);
                    System.out.println("Got it. I've added this task:\n"
                            + deadline.toString() + "\n"
                            + "Now you have " + taskList.tasks.size() + " tasks in the list.");
                } catch (IndexOutOfBoundsException e) {
                    DukeException errorMessage = new DukeException();
                    errorMessage.emptyDescription("deadline");
                }
                break;
            case "event":
                try {
                    String[] split = description.split("\\/", 2);
                    try {
                        split[1] = formatDate(split[1].substring(3));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Event event = new Event(split[0], split[1]);
                    taskList.tasks.add(event);
                    System.out.println("Got it. I've added this task:\n"
                            + event.toString() + "\n"
                            + "Now you have " + taskList.tasks.size() + " tasks in the list.");
                } catch (IndexOutOfBoundsException e) {
                    DukeException errorMessage = new DukeException();
                    errorMessage.emptyDescription("event");
                }break;
        }
    }

    public static String formatDate(String date) throws ParseException {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy HHmm");
        Date inputDate = new SimpleDateFormat("d/MM/yyyy HHmm").parse(date);
        String outputDate = outputFormat.format(inputDate);
        String suffix;
        switch(outputDate.substring(0, 2)) {
            case "11":
            case "12":
            case "13":
                suffix = "th of";
                break;
            default: switch (outputDate.substring(1, 2)) {
                case "1":
                    suffix = "st of";
                    break;
                case "2":
                    suffix = "nd of";
                    break;
                case "3":
                    suffix = "rd of";
                    break;
                default:
                    suffix = "th of";
            }
        }
        outputDate = outputDate.substring(0,2) + suffix + outputDate.substring(2);
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

    public static void deleteTask(String taskNumber, TaskList taskList) {
        int taskNo = Integer.parseInt(taskNumber);
        Task t = taskList.tasks.get(taskNo - 1);
        taskList.tasks.remove(t);
        System.out.println("Noted. I've removed this task: \n" +
                t + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.");
    }

    public static void findTask (String keyword, TaskList taskList) {
        ArrayList<Task> results = new ArrayList<>();
        for (Task t : taskList.tasks) {
            if (t.getDescription().contains(keyword)) {
                results.add(t);
            }
        }
        System.out.println("Here are the matching tasks in your list: ");
        for (int j = 0; j < results.size(); j++) {
            Task task = results.get(j);
            System.out.println((j + 1) + "." + task.toString());
        }
    }

    public static void markAsDone (String taskNumber, TaskList taskList) {
        try {
            int taskNo = Integer.parseInt(taskNumber);
            Task task = taskList.tasks.get(taskNo - 1);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("  " + task.toString());
        } catch (IndexOutOfBoundsException e) {
            DukeException errorMessage = new DukeException();
            errorMessage.emptyTaskNo();
        }
    }

    public static void listTask (TaskList taskList) {
        System.out.println("Here are the tasks in your list: ");
        for (int j = 0; j < taskList.tasks.size(); j++) {
            Task task = taskList.tasks.get(j);
            System.out.println((j + 1)+ "." + task.toString());
        }
    }
}
