package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Data.TaskDB;
import com.example.myapplication.Persistence.Task_persistence;
import com.example.myapplication.application.Service;

import java.util.ArrayList;
import java.util.List;

public class Access_task extends AppCompatActivity {

<<<<<<<<< Temporary merge branch 1
    private final List<Tasks> taskList;
=========
    private List<Tasks> allTasks;
>>>>>>>>> Temporary merge branch 2
    private final Task_persistence taskPersistence;
    private int numOfTasks;

    public Access_task(){
<<<<<<<<< Temporary merge branch 1

        taskPersistence = new TaskDB();
        taskList = taskPersistence.getTaskList();
=========
    // need a fake database here
        taskPersistence = Service.getTaskPersistence();
        allTasks=new ArrayList<>();
>>>>>>>>> Temporary merge branch 2
    }

    // this constructor is for later when we have a real persistence
    public Access_task(final Task_persistence taskPersistence){
        this.taskPersistence = taskPersistence;
        taskList = taskPersistence.getTaskList();
    }


    public final void addTask_accessTask(Tasks newTask){
        taskPersistence.addTask(newTask);
    }

    public final void removeTask(final Tasks taskToDel){
        taskPersistence.removeTask(taskToDel);
    }

<<<<<<<<< Temporary merge branch 1
    public final void updateTask(Tasks oldTask, Tasks newTask){
        taskPersistence.updateTask(oldTask, newTask);
    }

    public final List<Tasks> getTaskList() {
        return taskList;
    }

    //public final int getNewTaskId(){return taskPersistence.getNewTaskId(); }

=========
    public final void editTask(Tasks oldTask, Tasks newTask){
        taskPersistence.editTask(oldTask,newTask);
    }

    public final List<Tasks> getAllTasks() {
        allTasks = taskPersistence.getAllTasks();
        return allTasks;
    }

>>>>>>>>> Temporary merge branch 2







}
