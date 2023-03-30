package com.rb.tp1.logic;

public class Task extends Exception{
    private String title;

    private String description;

    private int priority;

    private boolean completed;

    public Task  (String title, String description, int priority, boolean completed) throws Exception {
        super("raté");
        setTitle(title);
        setCompleted(completed);
        setDescription(description);
        setPriority(priority);
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) throws Exception {
        if (title != null && title != ""){
            this.title = title;
        }else{
            throw new Exception("Titre vide");
        }
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

    public void setPriority(int priority) throws Exception {
        if(priority < 1 && priority > 4){
            this.priority = priority;
        }else{
            throw new Exception("priority not valide must be >0nd <5");
        }

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
