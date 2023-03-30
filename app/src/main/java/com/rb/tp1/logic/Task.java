package com.rb.tp1.logic;

public class Task {
    private String title;

    private String description;

    private int priority;

    private boolean completed;

    public Task(String title, String description, int priority, boolean completed) {
        setTitle(title);
        setCompleted(completed);
        setDescription(description);
        setPriority(priority);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return  title  + "   " +  priority ;
    }
}
