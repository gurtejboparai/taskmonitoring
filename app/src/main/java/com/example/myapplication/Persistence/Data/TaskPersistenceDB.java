package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Task_persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskPersistenceDB implements Task_persistence {
    List<Tasks> tasksList;
    int numOfTasks;

    public TaskPersistenceDB(){
        tasksList = new ArrayList<>();
    }

    public void addTasks(){
        numOfTasks = 0;
        this.tasksList.add(new Tasks(numOfTasks +1, "Call the doctor","setup appointment for Kevin","2021-03-02"));
        this.tasksList.add(new Tasks(numOfTasks +1,"Workout","Do cardio for 30 minutes","2021-03-04"));
        this.tasksList.add(new Tasks(numOfTasks +1,"COMP3350 due","Iteration-1 due on Friday","2021-03-03"));
        this.tasksList.add(new Tasks(numOfTasks +1,"Meal Prep","Prepare the meals for next 3 days and store","2021-03-03"));
        this.tasksList.add(new Tasks(numOfTasks +1,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28"));
        this.tasksList.add(new Tasks(numOfTasks +1,"Talk to the manager","Inform my new availability to the manager ","2021-03-03"));
    }


    @Override

    public int getNumOfTasks(){

        return numOfTasks;
    }

    public Tasks getTask(int taskId) {
        for(Tasks task : this.tasksList){
            if(task.getCurrTaskId()==taskId)
                return task;
        }
        return null;
    }

    public Tasks addTask(Tasks task){
        if(!this.tasksList.contains(task)){
            this.tasksList.add(task);
        }
        else
            return null;
        return task;
    }

    @Override
    public Tasks deleteTask(Tasks task) {
        return null;
    }

    @Override
    public void editTask(Tasks oldTask, Tasks newTask) {
        if(this.tasksList.contains(oldTask)){
            int index = this.tasksList.indexOf(oldTask);
            this.tasksList.set(index,newTask);
        }
    }

    @Override
    public void setTaskDate(Tasks task, String taskDate) {
        int index = this.tasksList.indexOf(task);
        if(index>=0){
            task.setTaskDate(taskDate);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public boolean checkForSame(Tasks task1, Tasks tasks2) {
        if(task1.getCurrTaskId()==tasks2.getCurrTaskId())
            return true;
        return false;
    }

    @Override
    public void setStatus(Tasks task, String status) {
        int index = this.tasksList.indexOf(task);
        if(index>=0){
            task.setTaskDate(status);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public List<Tasks> getAllTasks() {
        return this.tasksList;
    }

}
