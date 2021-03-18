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
        addTasks();
    }


    public int getNewTaskId(){return numOfTasks;}

    public void addTasks(){
        Task task1=new Task(numOfTasks, "Call the doctor","setup appointment for Kevin","2021-03-02");
        Task task2=new Task(numOfTasks +1,"Workout","Do cardio for 30 minutes","2021-03-04");
        Task task3=new Task(numOfTasks +2,"COMP3350 due","Iteration-1 due on Friday","2021-03-03");
        Task task4=new Task(numOfTasks +3,"Meal Prep","Prepare the meals for next 3 days and store","2021-03-03");
        Task task5=new Task(numOfTasks +4,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28");
        Task task6=new Task(numOfTasks +5,"Talk to the manager","Inform my new availability to the manager ","2021-03-03");
        this.tasksList.add(task1);
        this.tasksList.add(task2);
        this.tasksList.add(task3);
        this.tasksList.add(task4);
        this.tasksList.add(task5);
        this.tasksList.add(task6);
        task1.setPriority("True");
        task3.setPriority("True");
        task1.setCategory("Appointment");
        task2.setCategory("Fitness");
        task3.setCategory("School");
        task4.setCategory("Fitness");
        task5.setCategory("School");
        task6.setCategory("Work");

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
    public void editTask(Task oldTask, Task newTask) {
        if(this.tasksList.contains(oldTask)){
            int index = this.tasksList.indexOf(oldTask);
            this.tasksList.set(index,newTask);
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
