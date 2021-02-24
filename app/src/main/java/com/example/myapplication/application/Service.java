package com.example.myapplication.application;

import com.example.myapplication.Persistence.Data.TaskPersistenceDB;
import com.example.myapplication.Persistence.Task_persistence;

public class Service {
    private static Task_persistence taskPersistence = null;

    public static synchronized Task_persistence getTaskPersistence(){
        if(taskPersistence==null)
            taskPersistence = new TaskPersistenceDB();
        return taskPersistence;
    }
}
