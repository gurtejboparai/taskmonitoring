package com.example.myapplication.business;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.objects.TaskTag;
import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.data.TaskPersistenceDB;

import java.util.ArrayList;
import java.util.List;

public class AccessTask extends AppCompatActivity {

    private List<Task> allTasks;
    private final TaskPersistenceDB taskPersistence;

    public AccessTask(){

//        taskPersistence = Service.getTaskPersistence();
        taskPersistence = new TaskPersistenceDB();
        taskPersistence.addTasks();
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

    public void editTask(Task task){
        taskPersistence.editTask(task);
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

    public List<Task> getTasksByTag(TaskTag taskTag) {
        List<Task> taskList = new ArrayList<Task>();

        for (Task task : allTasks) {
            if (task.getTaskTag() == taskTag) {
                taskList.add(task);
            }
        }
        return taskList;
    }

}
