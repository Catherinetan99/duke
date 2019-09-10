public class Event extends Task {
    protected String at;

    /**
     * Constructor for Event class with only description and at
     * @param description description of event
     * @param at date and time of event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Constructor for Event class
     * @param description description of event
     * @param isDone boolean storing whether the event is completed
     * @param at date and time of event
     */
    public Event(String description, boolean isDone, String at) {
        super(description, isDone);
        this.at = at;
    }

    /**
     * Returns event in a string format
     * @return event in a string format
     */
    @Override
    public String toString() {
        return "  [E]" + super.toString() +"(at: " + at + ")";
    }
}
