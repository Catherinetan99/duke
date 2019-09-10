import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testTodoConstructor() {
        TaskList test = new TaskList();
        Todo todo = new Todo("water the flowers");
        assertEquals("  [T][✘] water the flowers", todo.toString());
    }
}
