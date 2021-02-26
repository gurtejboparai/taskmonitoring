package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.List;

public interface Task_persistence {

    int getNewTaskId();
    Tasks getTask(int taskId);
    Tasks addTask(final Tasks task);
    Tasks deleteTask( Tasks task);
    void editTask(Tasks oldTask, Tasks newTasks);
    boolean checkForSame(Tasks task1, Tasks task2);
    void setStatus(Tasks task, String newStatus);
    void setTaskDate(Tasks tak,String taskDate);

    List<Tasks> getAllTasks();
}
