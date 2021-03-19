package com.example.myapplication.objects;

import java.io.Serializable;

public class Task implements Serializable {
    private final int taskId;
    private String taskDate;
    private String taskTitle;
    private String taskDescription;
    private String status;
    private String priority;
    private TaskTag taskTag;
    private String taskCategory;

    public Task(int taskId,String taskTitle, String taskDescription, String taskDate){
        this.taskId = taskId;
        this.taskTitle=taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
        this.taskTag = TaskTag.OTHERS;
        this.priority="False";
    }


    public Task(final int taskId, String taskTitle, String taskDescription, String taskDate, String taskTag){
        this.taskId = taskId;
        this.taskTitle=taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
        this.priority="False";
        if(taskTag.equalsIgnoreCase(TaskTag.SCHOOL.toString()))
            this.taskTag=TaskTag.SCHOOL;
        else if(taskTag.equalsIgnoreCase(TaskTag.WORK.toString()))
            this.taskTag=TaskTag.WORK;
        else if(taskTag.equalsIgnoreCase(TaskTag.FITNESS.toString()))
            this.taskTag=TaskTag.FITNESS;
        else if(taskTag.equalsIgnoreCase(TaskTag.PRODUCTIVITY.toString()))
            this.taskTag=TaskTag.PRODUCTIVITY;
        else if(taskTag.equalsIgnoreCase(TaskTag.APPOINTMENT.toString()))
            this.taskTag=TaskTag.APPOINTMENT;
        else
            this.taskTag=TaskTag.OTHERS;
    }
    public Task(final int taskId, String taskTitle, String taskDescription, String taskDate, String taskTag, String priority){
        this.taskId = taskId;
        this.taskTitle=taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
        if(taskTag.equalsIgnoreCase(TaskTag.SCHOOL.toString()))
            this.taskTag=TaskTag.SCHOOL;
        else if(taskTag.equalsIgnoreCase(TaskTag.WORK.toString()))
            this.taskTag=TaskTag.WORK;
        else if(taskTag.equalsIgnoreCase(TaskTag.FITNESS.toString()))
            this.taskTag=TaskTag.FITNESS;
        else if(taskTag.equalsIgnoreCase(TaskTag.PRODUCTIVITY.toString()))
            this.taskTag=TaskTag.PRODUCTIVITY;
        else if(taskTag.equalsIgnoreCase(TaskTag.APPOINTMENT.toString()))
            this.taskTag=TaskTag.APPOINTMENT;
        else
            this.taskTag=TaskTag.OTHERS;
        this.priority=priority;
    }
    public Task(final int taskId, String taskTitle, String taskDescription, String taskDate,String taskTag,String status,String priority){
        this.taskId = taskId;
        this.taskTitle=taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = status;
        this.priority=priority;
        if(taskTag.equalsIgnoreCase(TaskTag.SCHOOL.toString()))
            this.taskTag=TaskTag.SCHOOL;
        else if(taskTag.equalsIgnoreCase(TaskTag.WORK.toString()))
            this.taskTag=TaskTag.WORK;
        else if(taskTag.equalsIgnoreCase(TaskTag.FITNESS.toString()))
            this.taskTag=TaskTag.FITNESS;
        else if(taskTag.equalsIgnoreCase(TaskTag.PRODUCTIVITY.toString()))
            this.taskTag=TaskTag.PRODUCTIVITY;
        else if(taskTag.equalsIgnoreCase(TaskTag.APPOINTMENT.toString()))
            this.taskTag=TaskTag.APPOINTMENT;
        else
            this.taskTag=TaskTag.OTHERS;
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
    public String getCategory()
    {
        return taskCategory;
    }
    public void setCategory(String taskTag)
    {
        taskCategory=taskTag;
        if(taskTag.equalsIgnoreCase(TaskTag.SCHOOL.toString()))
            this.taskTag=TaskTag.SCHOOL;
        else if(taskTag.equalsIgnoreCase(TaskTag.WORK.toString()))
            this.taskTag=TaskTag.WORK;
        else if(taskTag.equalsIgnoreCase(TaskTag.FITNESS.toString()))
            this.taskTag=TaskTag.FITNESS;
        else if(taskTag.equalsIgnoreCase(TaskTag.PRODUCTIVITY.toString()))
            this.taskTag=TaskTag.PRODUCTIVITY;
        else if(taskTag.equalsIgnoreCase(TaskTag.APPOINTMENT.toString()))
            this.taskTag=TaskTag.APPOINTMENT;
        else
            this.taskTag=TaskTag.OTHERS;
    }


    public TaskTag getTaskTag() { return taskTag; }
}
