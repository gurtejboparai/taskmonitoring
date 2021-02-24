package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Data.TaskDB;
import com.example.myapplication.Persistence.Task_persistence;



import java.util.List;

public class Access_task extends AppCompatActivity {

    private final List<Tasks> taskList;
    private final Task_persistence taskPersistence;
    private int numOfTasks;

    public Access_task(){

        taskPersistence = new TaskDB();
        taskList = taskPersistence.getTaskList();
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

    public final void updateTask(Tasks oldTask, Tasks newTask){
        taskPersistence.updateTask(oldTask, newTask);
    }

    public final List<Tasks> getTaskList() {
        return taskList;
    }

    //public final int getNewTaskId(){return taskPersistence.getNewTaskId(); }








}
