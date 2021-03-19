package com.example.myapplication.application;

import com.example.myapplication.persistence.data.TaskPersistenceDB;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;

public class Service {
    private static TaskPersistence taskPersistence = null;

    public static synchronized TaskPersistence getTaskPersistence(){
        if(taskPersistence==null)
            taskPersistence = new TaskPersistenceHSQLDB(Main.getDBPathName());
        return taskPersistence;
    }

}
