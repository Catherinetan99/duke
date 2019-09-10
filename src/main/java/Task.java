public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task class
     * @param description description of task
     * @param isDone boolean storing whether the task is completed
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Constructor for Task class with only description input, isDone is set to false
     * @param description description of task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Getter for isDone
     * @return whether the task is completed
     */
    public boolean isDone() { return isDone; }

    /**
     * Returns the status icon of the task based on the state of isDone
     * @return the status icon of the task (tick or cross symbols)
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Getter for description
     * @return description of task
     */
    public String getDescription() { return description; }

    /**
     * Sets isDone of task to true
     */
    public void markAsDone () {
        this.isDone = true;
    }

    /**
     * Returns the task in a string format
     * @return task in a string format
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}