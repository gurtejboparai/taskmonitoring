package com.example.myapplication.Object;

import java.util.Date;

public class Tasks {
    private final int taskId;
    private String taskDate;
    private String taskTitle;
    private String taskDescription;
    private String status;

    public Tasks(final int taskId, String taskTitle, String taskDescription, String taskDate){
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
    }

    public int getCurrTaskId(){return taskId;}

    public String getTaskTitle(){return taskTitle;}

    public void setTaskTitle(String taskTitle){this.taskTitle = taskTitle;}

    public String getTaskDescription(){return taskDescription;}

    public void setTaskDescription(String taskDescription){this.taskDescription = taskDescription;}

    public String getTaskDate() {return taskDate;}

    public void setTaskDate(String taskDate){this.taskDate = taskDate;}

    public boolean checkForSame(Tasks task1){
        if(this.taskId==task1.taskId){
            return true;
        }
        else
            return false;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }
}
