package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.List;

public interface Task_persistence {

    //int getNewTaskId();
    //Tasks getTask(int taskId);

    void addTask(final Tasks task);
    void removeTask(final Tasks task);
    void updateTask(final Tasks oldTask, Tasks newTask);

    List<Tasks> getTaskList();

}
