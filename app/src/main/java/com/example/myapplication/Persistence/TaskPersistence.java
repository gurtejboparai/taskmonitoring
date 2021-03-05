package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Task;

import java.util.List;

public interface TaskPersistence {

    int getNewTaskId();
    Task getTask(int taskId);
    Task addTask(final Task task);
    Task deleteTask(Task task);
    void editTask(Task oldTask, Task newTasks);
    boolean checkForSame(Task task1, Task task2);
    void setStatus(Task task, String newStatus) throws Task.InPutNull;
    void setTaskDate(Task tak, String taskDate) throws Task.InPutNull;

    List<Task> getAllTasks();
}
