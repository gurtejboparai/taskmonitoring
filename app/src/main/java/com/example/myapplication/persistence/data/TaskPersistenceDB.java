package com.example.myapplication.persistence.data;

import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;

import java.util.ArrayList;
import java.util.List;

public class TaskPersistenceDB implements TaskPersistence {
    List<Task> tasksList;
    private int numOfTasks=0;

    public TaskPersistenceDB(){
        tasksList = new ArrayList<>();
    }


    public int getNewTaskId(){return numOfTasks++;}

    public void addTasks(){
        this.tasksList.add(new Task(numOfTasks, "Call the doctor","setup appointment for Kevin","02-03-2021"));
        this.tasksList.add(new Task(numOfTasks +1,"Workout","Do cardio for 30 minutes","03-03-2021"));
        this.tasksList.add(new Task(numOfTasks +2,"COMP3350 due","Iteration-1 due on Friday","04-03-2021"));
        this.tasksList.add(new Task(numOfTasks +3,"Meal Prep","Prepare the meals for next 3 days and store","08-03-2021"));
        this.tasksList.add(new Task(numOfTasks +4,"COMP3340 lab","Lab-3 is due tomorrow", "07-03-2021"));
        this.tasksList.add(new Task(numOfTasks +5,"Talk to the manager","Inform my new availability to the manager ","10-03-2021"));
    }


    public Task getTask(int taskId) {
        Task result = null;
        for(Task task : this.tasksList){
            if(task.getCurrTaskId()==taskId)
                result =task;
        }
        return result;
    }

    public Task addTask(Task task){
        if(!this.tasksList.contains(task)){
            this.tasksList.add(task);
        }
        else
            return null;
        return task;
    }

    @Override
    public Task deleteTask(Task task) {
        int index = tasksList.indexOf(task);
        if(index>=0)
            tasksList.remove(task);
        if(tasksList.contains(task))
            return null;
        else
            return task;
    }

    @Override
    public void editTask(Task task) {
        if(this.tasksList.contains(task)){
            int index = this.tasksList.indexOf(task);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public void setTaskDate(Task task, String taskDate){
        int index = this.tasksList.indexOf(task);
        if(index>=0){
            task.setTaskDate(taskDate);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public boolean checkForSame(Task task1, Task tasks2) {
        return task1.getCurrTaskId() == tasks2.getCurrTaskId();

    }

    @Override
    public void setStatus(Task task, String status) {
        int index = this.tasksList.indexOf(task);
        if(index>=0){
            task.setTaskDate(status);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return this.tasksList;
    }


}
