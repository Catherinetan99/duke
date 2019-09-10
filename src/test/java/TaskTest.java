import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void testMarkAsDoneMethod() {
        Todo todo = new Todo("finish assignment");
        todo.markAsDone();
        assertEquals("\u2713", todo.getStatusIcon());
    }

    @Test
    public void testGetDescription() {
        Task task = new Task("finish assignment");
        assertEquals("finish assignment", task.description);
    }
}
