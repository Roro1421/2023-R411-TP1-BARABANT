package com.rb.tp1.logic;

public class FakeDao implements IStorageTasks{

    TaskList taskList = new TaskList();

    public FakeDao() {
        Task test = new Task("Test","test Fake",3,false);

        Task ouioui = new Task("Ouioui","ouioui fake",1,true);

        taskList.AddTask(test);
        taskList.AddTask(ouioui);
    }

    @Override
    public TaskList ReadTasks() {
        return taskList;
    }
}
