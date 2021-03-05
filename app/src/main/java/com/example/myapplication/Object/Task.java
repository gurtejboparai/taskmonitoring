package com.example.myapplication.Object;

public class Task {
    private final int taskId;
    private String taskDate;
    private String taskTitle;
    private String taskDescription;
    private String status;

    public Task(final int taskId, String taskTitle, String taskDescription, String taskDate){
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.status = "on going";
    }

    public int getCurrTaskId(){return taskId;}

    public String getTaskTitle(){return taskTitle;}

    public void setTaskTitle(String taskTitle)throws InPutNull{
        if(taskTitle==null)
            throw new InPutNull();
        else
            this.taskTitle = taskTitle;
    }

    public String getTaskDescription(){return taskDescription;}

    public void setTaskDescription(String taskDescription)throws InPutNull{
        if(taskDescription==null)
            throw new InPutNull();
        else
        this.taskDescription = taskDescription;
    }

    public String getTaskDate() {return taskDate;}

    public void setTaskDate(String taskDate)throws InPutNull{
        if(taskDate==null)
            throw new InPutNull();
        else
        this.taskDate = taskDate;}

    public boolean checkForSame(Task task1)throws InPutNull{
        if(task1==null){
            throw new InPutNull();
        }else if(this.taskId == task1.taskId){

           return true;

        }else {
            return false;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String newStatus)throws InPutNull{
        if(newStatus==null)
            throw new InPutNull();
        else
        this.status = newStatus;
    }
    public class InPutNull extends Exception{
        public InPutNull(){
            super("the Parameter is null");
        }

    }

}
