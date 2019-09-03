import java.io.*;

public class Duke {
    private static final String filePath = "C:\\Users\\Catherine Tan\\IdeaProjects\\duke\\data\\duke.txt";
    public static void main(String[] args) throws IOException {
        TaskList taskList = new TaskList();
        Storage.loadFile(filePath, taskList);
        Ui.sayHi();
        String input = Ui.readIn();
        while(!input.equals("bye")) {
            Parser parser = new Parser(input, taskList);
            parser.executeCmd(input, taskList);
            Storage.updateFile(taskList);
            input = Ui.readIn();
        }
        Ui.sayBye();
    }
}
