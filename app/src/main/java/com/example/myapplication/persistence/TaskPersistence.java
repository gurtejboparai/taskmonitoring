package com.example.myapplication.persistence;

import com.example.myapplication.objects.Task;

import java.util.List;

public interface TaskPersistence {

    int getNewTaskId();
    Task getTask(int taskId);
    Task addTask(final Task task);
    Task deleteTask( Task task);
    void editTask(Task task);
    boolean checkForSame(Task task1, Task task2);
    void setStatus(Task task, String newStatus) ;
    void setTaskDate(Task tak,String taskDate) ;

    List<Task> getAllTasks();
}
