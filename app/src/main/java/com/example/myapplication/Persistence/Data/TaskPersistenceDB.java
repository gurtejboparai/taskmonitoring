package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.TaskPersistence;

import java.util.ArrayList;
import java.util.List;

public class TaskPersistenceDB implements TaskPersistence {
    List<Tasks> tasksList;
    private int numOfTasks=0;

    public TaskPersistenceDB(){
        tasksList = new ArrayList<>();
    }


    public int getNewTaskId(){return numOfTasks;}

    public void addTasks(){
        this.tasksList.add(new Tasks(numOfTasks, "Call the doctor","setup appointment for Kevin","2021-03-02"));
        this.tasksList.add(new Tasks(numOfTasks +1,"Workout","Do cardio for 30 minutes","2021-03-04"));
        this.tasksList.add(new Tasks(numOfTasks +2,"COMP3350 due","Iteration-1 due on Friday","2021-03-03"));
        this.tasksList.add(new Tasks(numOfTasks +3,"Meal Prep","Prepare the meals for next 3 days and store","2021-03-03"));
        this.tasksList.add(new Tasks(numOfTasks +4,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28"));
        this.tasksList.add(new Tasks(numOfTasks +5,"Talk to the manager","Inform my new availability to the manager ","2021-03-03"));
    }


    public Tasks getTask(int taskId) {
        Tasks result = null;
        for(Tasks task : this.tasksList){
            if(task.getCurrTaskId()==taskId)
                result =task;
        }
        return result;
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
        int index = tasksList.indexOf(task);
        if(index>=0)
            tasksList.remove(task);
        if(tasksList.contains(task))
            return null;
        else
            return task;
    }

    @Override
    public void editTask(Tasks oldTask, Tasks newTask) {
        if(this.tasksList.contains(oldTask)){
            int index = this.tasksList.indexOf(oldTask);
            this.tasksList.set(index,newTask);
        }
    }

    @Override
    public void setTaskDate(Tasks task, String taskDate){
        int index = this.tasksList.indexOf(task);
        if(index>=0){
            task.setTaskDate(taskDate);
            this.tasksList.set(index,task);
        }
    }

    @Override
    public boolean checkForSame(Tasks task1, Tasks tasks2) {
        return task1.getCurrTaskId() == tasks2.getCurrTaskId();
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
