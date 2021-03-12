package com.example.myapplication.application;

import com.example.myapplication.Persistence.Data.TaskPersistenceDB;
import com.example.myapplication.Persistence.TaskPersistence;

public class Service {
    private static TaskPersistence taskPersistence = null;

    public static synchronized TaskPersistence getTaskPersistence(){
        if(taskPersistence==null)
            taskPersistence = new TaskPersistenceDB();
        return taskPersistence;
    }

}
