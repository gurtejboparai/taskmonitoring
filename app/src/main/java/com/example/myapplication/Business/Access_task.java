package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Data.TaskPersistenceDB;
import com.example.myapplication.Persistence.Task_persistence;
import com.example.myapplication.application.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Access_task extends AppCompatActivity {

    private List<Tasks> allTasks;
    private TaskPersistenceDB taskPersistence;

    public Access_task(){

//        taskPersistence = Service.getTaskPersistence();
        taskPersistence = new TaskPersistenceDB();
        allTasks=new ArrayList<>();
    }

    // we don't need this constructor for this iteration
//    public Access_task(Task_persistence taskPersistence){
//        this.taskPersistence = taskPersistence;
//        allTasks = taskPersistence.getAllTasks();
//    }

    public Tasks getTask(int taskId) {
        return taskPersistence.getTask(taskId);
    }

    public Tasks addTask(final Tasks newTask){
//        if(newTask.getTaskTitle() == null || newTask.getTaskDescription() == null || newTask.getTaskDate() == null){ //if(newTask == null)
//            String taskCreateMessage = "Please enter all fields.";
//            Toast.makeText(getApplicationContext(), taskCreateMessage, Toast.LENGTH_SHORT).show();
//        }
        return taskPersistence.addTask(newTask);
    }

    public Tasks deleteTask(Tasks taskToDel){
        return taskPersistence.deleteTask(taskToDel);
    }

    public void editTask(Tasks oldTask, Tasks newTask){
        taskPersistence.editTask(oldTask,newTask);
    }

    public void setTaskDate(Tasks task, String taskDate){
        try {
            taskPersistence.setTaskDate(task, taskDate);
        }catch ( Tasks.InPutNull e){
            System.out.println(e.getMessage());
        }
    }

    public List<Tasks> getAllTasks() {
        allTasks = taskPersistence.getAllTasks();
        return allTasks;
    }
    public void setStatus(Tasks task, String newStatus){
        try{
        taskPersistence.setStatus(task,newStatus);
        }catch ( Tasks.InPutNull e){
        System.out.println(e.getMessage());
        }
    }
    public boolean checkForSame(Tasks task, Tasks task1){
        return taskPersistence.checkForSame(task, task1);
    }

    public final int getNewTaskId(){
        return taskPersistence.getNewTaskId();
    }


}
