public class Parser {
    protected String input;
    protected TaskList taskList;

    public Parser (String input, TaskList taskList) {
        this.input = input;
        this.taskList = taskList;
    }

    public void executeCmd (String input, TaskList taskList) {
        String command[] = input.split(" ", 2);
        switch (command[0]) {
            case "list":
                TaskList.listTask(taskList);
                break;
            case "done":
                TaskList.markAsDone(command[1], taskList);
                break;
            case "delete":
                TaskList.deleteTask(command[1], taskList);
                break;
            case "find":
                TaskList.findTask(command[1], taskList);
                break;
            case "todo":
                TaskList.addTask("todo", command[1], taskList);
                break;
            case "event":
                TaskList.addTask("event", command[1], taskList);
                break;
            case "deadline":
                TaskList.addTask("deadline", command[1], taskList);
                break;
            default:
                DukeException errorMessage = new DukeException();
                errorMessage.invalidInput();
        }
    }
}
