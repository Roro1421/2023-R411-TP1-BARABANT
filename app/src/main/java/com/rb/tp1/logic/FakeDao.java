package com.rb.tp1.logic;

public class FakeDao extends Exception implements IStorageTasks{

    TaskList taskList = new TaskList();

    public FakeDao() throws Exception {
        super("raté");
        Task test = new Task("Test","test Fake",3,false);

        Task ouioui = new Task("Ouioui","ouioui fake",1,true);

        Task non = new Task("non","non fake",3,true);

        taskList.AddTask(test);
        taskList.AddTask(ouioui);
        //taskList.AddTask(non);
    }

    @Override
    public TaskList ReadTasks() {
        return taskList;
    }

    @Override
    public void AddTask(Task task) {

    }

    @Override
    public void UpdateTask(Task task) {

    }
}
