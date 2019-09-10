public class Parser {
    protected String input;
    protected TaskList taskList;

    /**
     * Constructor for Parser class
     * @param input command input by user
     * @param taskList list of tasks currently
     */
    public Parser (String input, TaskList taskList) {
        this.input = input;
        this.taskList = taskList;
    }

    /**
     * Executes command input by user
     * @param input command input by user
     * @param taskList list of tasks currently
     */
    public void executeCmd (String input, TaskList taskList) {
        String command[] = input.split(" ", 2);
        switch (command[0]) {
            case "list":
                taskList.listTask();
                break;
            case "done":
                taskList.markAsDone(command[1]);
                break;
            case "delete":
                taskList.deleteTask(command[1]);
                break;
            case "find":
                taskList.findTask(command[1]);
                break;
            case "todo":
                taskList.addTask("todo", command[1]);
                break;
            case "event":
                taskList.addTask("event", command[1]);
                break;
            case "deadline":
                taskList.addTask("deadline", command[1]);
                break;
            default:
                DukeException errorMessage = new DukeException();
                errorMessage.invalidInput();
        }
    }
}
