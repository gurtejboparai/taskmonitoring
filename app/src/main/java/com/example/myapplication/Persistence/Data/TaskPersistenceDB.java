package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Task_persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskPersistenceDB implements Task_persistence {
    List<Tasks> tasksList;
    private int numOfTasks = 0;
    public TaskPersistenceDB(){
        tasksList = new ArrayList<>();
    }

    public void addTasks(){
        this.tasksList.add(new Tasks(numOfTasks+1, "Call the doctor","setup appointment for Kevin", new Date()));
        this.tasksList.add(new Tasks(numOfTasks+1,"Workout","Do cardio for 30 minutes",new Date()));
        this.tasksList.add(new Tasks(numOfTasks+1,"COMP3350 due","Iteration-1 due on Friday",new Date()));
        this.tasksList.add(new Tasks(numOfTasks+1,"Meal Prep","Prepare the meals for next 3 days and store",new Date()));
        this.tasksList.add(new Tasks(numOfTasks+1,"COMP3340 lab","Lab-3 is due tomorrow",new Date()));
        this.tasksList.add(new Tasks(numOfTasks+1,"Talk to the manager","Inform my new availability to the manager ",new Date()));
    }


    @Override
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
    public List<Tasks> getAllTasks() {
        return this.tasksList;
    }

}
