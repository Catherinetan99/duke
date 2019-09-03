import java.io.*;

public class Storage {

    private static final String filePath = "C:\\Users\\Catherine Tan\\IdeaProjects\\duke\\data\\duke.txt";

    public static void loadFile (String filePath, TaskList taskList) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String st;
        while((st=br.readLine()) != null) {
            String[] phrase = st.split("\\[");
            boolean isDone = false;
            if (phrase[2].contains("✓")) {
                isDone = true;
            }
            String description = phrase[2].substring(3);
            if (phrase[1].startsWith("T")) {
                Todo todo = new Todo(description, isDone);
                taskList.tasks.add(todo);
            } else if (phrase[1].startsWith("D")) {
                String[] phrase2 = phrase[2].split("\\(");
                int length = phrase2[1].length();
                String by = phrase2[1].substring(4, length);
                Deadline deadline = new Deadline(description, isDone, by);
                taskList.tasks.add(deadline);
            } else { // event
                String[] phrase2 = phrase[2].split("\\(");
                int length = phrase2[1].length();
                String at = phrase2[1].substring(4, length);
                Event event = new Event(description, isDone, at);
                taskList.tasks.add(event);
            }
        }
    }

    public static void updateFile (TaskList taskList) {
        File f = new File(filePath);
        try {
            PrintWriter outputStream = new PrintWriter(f);
            for (int i = 0; i < taskList.tasks.size(); i++) {
                Task task = taskList.tasks.get(i);
                outputStream.println(task.toString());
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
