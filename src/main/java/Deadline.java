public class Deadline extends Task {

    protected String by;

    /**
     * Constructor for Deadline class with only description and by
     * @param description description of deadline task
     * @param by deadline of task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Constructor for Deadline class
     * @param description description of deadline task
     * @param isDone boolean storing whether the deadline task is completed
     * @param by deadline of task
     */
    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns the deadline in a string format
     * @return deadline in a string format
     */
    @Override
    public String toString() {
        return "  [D]" + super.toString() + "(by: " + by + ")";
    }
}
