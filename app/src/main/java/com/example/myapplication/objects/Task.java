package com.example.myapplication.objects;

public class Task {
    private final int taskId;
    private String taskDate;
    private String taskTitle;
    private String taskDescription;
    private String status;
    private String priority;
    private TaskTag taskTag;

    public Task(final int taskId, String taskTitle, String taskDescription, String taskDate){
        this.taskId = taskId;
        if(taskTitle.length()==0)
            this.taskTitle = "no Title";
        else {
            this.taskTitle = taskTitle;
        }
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
    }

    public int getCurrTaskId(){return taskId;}

    public String getTaskTitle(){return taskTitle;}

    public void setTaskTitle(String taskTitle){
            this.taskTitle = taskTitle;
    }

    public String getTaskDescription(){return taskDescription;}

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public String getTaskDate() {return taskDate;}

    public void setTaskDate(String taskDate){
        this.taskDate = taskDate;}

    public boolean checkForSame(Task task1){
        return this.taskId == task1.taskId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String newStatus){
        if(newStatus.length()!=0)
            this.status = newStatus;
    }

    public String getPriority() { return priority; }

    public void setPriority(String priority) {

        this.priority = priority;
    }

    private boolean validateDate(String date){
        return true;
    }

    public TaskTag getTaskTag() { return taskTag; }
}
