package com.example.myapplication.application;

import com.example.myapplication.Persistence.Data.TaskPersistenceDB;
import com.example.myapplication.Persistence.Data.DayPersistenceDB;
import com.example.myapplication.Persistence.DayPersistence;
import com.example.myapplication.Persistence.TaskPersistence;

public class Service {
    private static TaskPersistence taskPersistence = null;
    private static DayPersistence dayPersistence = null;

    public static synchronized TaskPersistence getTaskPersistence(){
        if(taskPersistence==null)
            taskPersistence = new TaskPersistenceDB();
        return taskPersistence;
    }

    public  static synchronized DayPersistence getDayPersistence(){
        if(dayPersistence==null)
            dayPersistence = new DayPersistenceDB();
        return dayPersistence;
    }
}
