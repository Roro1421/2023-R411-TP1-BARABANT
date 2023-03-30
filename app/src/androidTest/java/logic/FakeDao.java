package logic;

public class FakeDao implements IStorageTasks{
    @Override
    public TaskList ReadTasks() {

        TaskList taskList = new TaskList();
        Task test = new Task();
        test.setCompleted(false);
        test.setDescription("test fake");
        test.setPriority(3);
        test.setTitle("Test");

        Task ouioui = new Task();
        ouioui.setCompleted(true);
        ouioui.setDescription("ouioui fake");
        ouioui.setPriority(1);
        ouioui.setTitle("Ouioui");

        taskList.AddTask(test);
        taskList.AddTask(ouioui);
        return taskList;
    }
}
