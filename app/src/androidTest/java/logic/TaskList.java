package logic;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void AddTask(Task task){
        tasks.add(task);
    }

    public void AddRemove(Task task){
        tasks.remove(task);
    }

}
