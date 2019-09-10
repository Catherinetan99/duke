import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskList {

    ArrayList<Task> tasks;

    /**
     * Constructor for TaskList class
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Getter for TaskList
     * @return list of tasks in ArrayList<Task>
     */
    public ArrayList<Task> getTasks() { return tasks; }

    /**
     * Getter for a specific task in TaskList
     * @param index the index of the task in the ArrayList
     * @return the task
     */
    public Task getSpecificTask(int index) {
        return tasks.get(index);
    }

    /**
     * Adds task into TaskList
     * @param taskType type of task, eg todo, deadline, event
     * @param description description of task
     */
    public void addTask(String taskType, String description) {
        switch(taskType) {
            case "todo":
                try {
                    Todo todo = new Todo(description);
                    tasks.add(todo);
                    System.out.println("Got it. I've added this task:\n"
                            + todo.toString() + "\n"
                            + "Now you have " + tasks.size() + " tasks in the list.");
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
                    tasks.add(deadline);
                    System.out.println("Got it. I've added this task:\n"
                            + deadline.toString() + "\n"
                            + "Now you have " + tasks.size() + " tasks in the list.");
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
                    tasks.add(event);
                    System.out.println("Got it. I've added this task:\n"
                            + event.toString() + "\n"
                            + "Now you have " + tasks.size() + " tasks in the list.");
                } catch (IndexOutOfBoundsException e) {
                    DukeException errorMessage = new DukeException();
                    errorMessage.emptyDescription("event");
                }break;
        }
    }

    /**
     * Format input date of user
     * @param date input date of user
     * @return the formatted date
     * @throws ParseException throws exception if input date is in invalid format
     */
    public String formatDate(String date) throws ParseException {
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

    /**
     * Deletes task from TaskList
     * @param taskNumber task number in TaskList
     */
    public void deleteTask(String taskNumber) {
        int taskNo = Integer.parseInt(taskNumber);
        Task t = tasks.get(taskNo - 1);
        tasks.remove(t);
        System.out.println("Noted. I've removed this task: \n" +
                t + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Finds task based on keyword input in TaskList
     * @param keyword keyword to find task
     */
    public void findTask (String keyword) {
        ArrayList<Task> results = new ArrayList<>();
        for (Task t: tasks) {
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

    /**
     * Marks the task as completed
     * @param taskNumber task number in TaskList
     */
    public void markAsDone (String taskNumber) {
        try {
            int taskNo = Integer.parseInt(taskNumber);
            Task task = tasks.get(taskNo - 1);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("  " + task.toString());
        } catch (IndexOutOfBoundsException e) {
            DukeException errorMessage = new DukeException();
            errorMessage.emptyTaskNo();
        }
    }

    /**
     * Lists all the tasks in TaskList
     */
    public void listTask () {
        System.out.println("Here are the tasks in your list: ");
        for (int j = 0; j < tasks.size(); j++) {
            Task task = tasks.get(j);
            System.out.println((j + 1)+ "." + task.toString());
        }
    }
}
