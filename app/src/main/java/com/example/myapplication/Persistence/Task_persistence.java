package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Tasks;

import java.util.List;

public interface Task_persistence {

<<<<<<<<< Temporary merge branch 1
    //int getNewTaskId();
    //Tasks getTask(int taskId);

    void addTask(final Tasks task);
    void removeTask(final Tasks task);
    void updateTask(final Tasks oldTask, Tasks newTask);

    List<Tasks> getTaskList();

=========
    Tasks getTask(int taskId);
    Tasks addTask(final Tasks task);
    Tasks deleteTask( Tasks task);
    void editTask(Tasks oldTask, Tasks newTasks);

    List<Tasks> getAllTasks();
>>>>>>>>> Temporary merge branch 2
}
