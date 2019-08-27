public class DukeException {

    public void emptyDescription (String task) {
        System.out.println("☹ OOPS!!! The description of a " + task + " cannot be empty.");
    }

    public void invalidInput () {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void emptyTaskNo () {
        System.out.println("☹ OOPS!!! The task number cannot be empty/is not valid.");
    }
}
