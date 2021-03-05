package com.example.myapplication.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Task;
import com.example.myapplication.Persistence.Data.TaskPersistenceDB;

import java.util.ArrayList;
import java.util.List;

public class AccessTask extends AppCompatActivity {

    private List<Task> allTasks;
    private final TaskPersistenceDB taskPersistence;

    public AccessTask(){

//        taskPersistence = Service.getTaskPersistence();
        taskPersistence = new TaskPersistenceDB();
        allTasks=new ArrayList<>();
    }
    public AccessTask(TaskPersistenceDB DB){
        taskPersistence = DB;
        allTasks= DB.getAllTasks();
    }

    // we don't need this constructor for this iteration
//    public Access_task(Task_persistence taskPersistence){
//        this.taskPersistence = taskPersistence;
//        allTasks = taskPersistence.getAllTasks();
//    }

    public Task getTask(int taskId) {
        return taskPersistence.getTask(taskId);
    }

    public Task addTask(final Task newTask){
//        if(newTask.getTaskTitle() == null || newTask.getTaskDescription() == null || newTask.getTaskDate() == null){ //if(newTask == null)
//            String taskCreateMessage = "Please enter all fields.";
//            Toast.makeText(getApplicationContext(), taskCreateMessage, Toast.LENGTH_SHORT).show();
//        }
        return taskPersistence.addTask(newTask);
    }

    public Task deleteTask(Task taskToDel){
        return taskPersistence.deleteTask(taskToDel);
    }

    public void editTask(Task oldTask, Task newTask){
        taskPersistence.editTask(oldTask,newTask);
    }

    public void setTaskDate(Task task, String taskDate){
        taskPersistence.setTaskDate(task, taskDate);
    }

    public List<Task> getAllTasks() {
        allTasks = taskPersistence.getAllTasks();
        return allTasks;
    }
    public void setStatus(Task task, String newStatus){
        taskPersistence.setStatus(task,newStatus);
    }
    public boolean checkForSame(Task task, Task task1){
        return taskPersistence.checkForSame(task, task1);
    }

    public final int getNewTaskId(){
        return taskPersistence.getNewTaskId();
    }


}
