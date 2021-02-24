package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Task_persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDB implements Task_persistence
{
    private List<Tasks> taskList;
    private int numOfTasks;

    public TaskDB()
    {
        this.taskList=new ArrayList<Tasks>();
        numOfTasks=0;
    }
    public static void main()
    {
        TaskDB ob=new TaskDB();
        ob.createTaskList();
        ob.printTaskList();
    }
    protected void createTaskList()
    {
        addTask(new Tasks(numOfTasks+1,"Call the doctor","Set up an appointment for next Thursday",new Date()));
        addTask(new Tasks(numOfTasks+1,"Workout","Do cardio for 30 minutes",new Date()));
        addTask(new Tasks(numOfTasks+1,"COMP3350 due","Iteration-1 due on Friday",new Date()));
        addTask(new Tasks(numOfTasks+1,"Meal Prep","Prepare the meals for next 3 days and store",new Date()));
        addTask(new Tasks(numOfTasks+1,"COMP3340 lab","Lab-3 is due tomorrow",new Date()));
        addTask(new Tasks(numOfTasks+1,"Talk to the manager","Inform my new availability to the manager ",new Date()));
    }
    public List<Tasks> getTaskList() {
        return taskList;
    }
    public void addTask(Tasks t)
    {
        taskList.add(t);
        numOfTasks++;
    }
    public void removeTask(Tasks t)
    {
        int index = taskList.indexOf(t);
        if(index<0)
        {
            System.out.println("Task: "+t.getTaskTitle()+" does not exists");
        }
        else {
            taskList.remove(index);
            numOfTasks--;
        }
    }
    public void updateTask(Tasks oldTask, Tasks newTask)
    {
        int index = taskList.indexOf(oldTask);
        if(index<0)
        {
            System.out.println("Task: "+oldTask.getTaskTitle()+" does not exists");
        }
        else
        {
            taskList.set(index,newTask);
        }
    }
    public void printTaskList()
    {
        for(int i=0;i<numOfTasks;i++)
            System.out.println(taskList.get(i).getTaskTitle());
    }

}
