public class DukeException {

    /**
     * Prints out error statement when description of task is empty
     * @param taskType the type of task, eg todo, deadline, event
     */
    public void emptyDescription (String taskType) {
        System.out.println("☹ OOPS!!! The description of a " + taskType + " cannot be empty.");
    }

    /**
     * Prints out error statement when input instruction is not recognised
     */
    public void invalidInput () {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Prints out error statement when the input task number is empty or invalid
     */
    public void emptyTaskNo () {
        System.out.println("☹ OOPS!!! The task number cannot be empty/is not valid.");
    }
}
