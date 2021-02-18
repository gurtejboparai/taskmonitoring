package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Task_persistence;



import java.util.List;

public class Access_task extends AppCompatActivity {

    private final List<Tasks> allTasks;
    private final Task_persistence taskPersistence;

    public Access_task(){
    // need a fake database here
        allTasks = taskPersistence.getAllTasks();
    }

    public Access_task(final Task_persistence taskPersistence){
        this.taskPersistence = taskPersistence;
        allTasks = taskPersistence.getAllTasks();
    }

    public final Tasks getTask(int taskId) {
        return taskPersistence.getTask(taskId);
    }

    public final Tasks addTask(final Tasks newTask){
        if(newTask.getTaskTitle() == null || newTask.getTaskDescription() == null || newTask.getTaskDate() == null){ //if(newTask == null)
            String taskCreateMessage = "Please enter all fields.";
            Toast.makeText(getApplicationContext(), taskCreateMessage, Toast.LENGTH_SHORT).show();
        }
        return taskPersistence.addTask(newTask);
    }

    public final Tasks deleteTask(final Tasks taskToDel){
        return taskPersistence.deleteTask(taskToDel);
    }

    public final void editTask(Tasks task){
        taskPersistence.editTask(task);
    }

    public final List<Tasks> getAllTasks() {
        return allTasks;
    }

    public final int getNewTaskId(){
        return taskPersistence.getNewTaskId();
    }








}
