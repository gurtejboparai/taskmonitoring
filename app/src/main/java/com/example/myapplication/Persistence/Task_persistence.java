package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.List;

public interface Task_persistence {

    Tasks getTask(int taskId);
    Tasks addTask(final Tasks task);
    Tasks deleteTask(final Tasks task);
    void editTask(final Tasks task);

    List<Tasks> getAllTasks();
    int getNewTaskId();
}
