package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.Date;
import java.util.List;

public interface Task_persistence {

    Tasks getTask(int taskId);
    Tasks addTask(Tasks task);
    Tasks deleteTask( Tasks task);
    void editTask(Tasks oldTask, Tasks newTasks);
    void setTaskDate(Tasks target, String taskDate);
    boolean checkForSame(Tasks task1, Tasks tasks2);
    void setStatus(Tasks task, String status);

    List<Tasks> getAllTasks();
}
