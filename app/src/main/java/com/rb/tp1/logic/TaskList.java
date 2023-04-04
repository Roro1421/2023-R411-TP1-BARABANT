package com.rb.tp1.logic;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void AddTask(Task task){
        tasks.add(task);
    }

    public void RemoveTask(Task task){
        tasks.remove(task);
    }

}
