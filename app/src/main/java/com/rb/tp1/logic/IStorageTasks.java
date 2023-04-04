package com.rb.tp1.logic;

public interface IStorageTasks {

    public TaskList ReadTasks() throws Exception;

    public void AddTask(Task task);

    public void UpdateTask(Task task);

}
