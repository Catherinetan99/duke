public class Todo extends Task {

    /**
     * Constructor for Todo class with only description
     * @param description description of todo
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Constructor for Todo class
     * @param description description of todo
     * @param isDone boolean storing whether the todo is completed
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns todo in a string format
     * @return todo in a string format
     */
    @Override
    public String toString() {
        return "  [T]" + super.toString();
    }
}
