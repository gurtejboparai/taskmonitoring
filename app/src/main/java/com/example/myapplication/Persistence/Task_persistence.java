package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.List;

public interface Task_persistence {

    Tasks getTasks(int taskId);
    Tasks addTasks(final Tasks task);
    Tasks deleteTasks(final Tasks task);
    void editTasks(final Tasks task);

    List<Tasks> getAllTasks();
    int getNewTaskId();
}
