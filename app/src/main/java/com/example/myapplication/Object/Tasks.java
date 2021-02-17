package com.example.myapplication.Object;

import java.util.Date;

public class Tasks {
    private int taskId;
    private Date taskDate;
    private String taskTitle;
    private String taskDescription;

    public Tasks(final int taskId, String taskTitle, String taskDescription, Date taskDate){
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
    }

    public int getTaskId(){return taskId;}
    public String getTaskTitle(){return taskTitle;}
    public void setTaskTitle(String taskTitle){this.taskTitle = taskTitle;}
    public String getTaskDescription(){return taskDescription;}
    public void setTaskDescription(String taskDescription){this.taskDescription = taskDescription;}
    public Date getTaskDate() {return taskDate;}
    public void setTaskDate(Date taskDate){this.taskDate = taskDate;}
}
