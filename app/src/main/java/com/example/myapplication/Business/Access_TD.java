package com.example.myapplication.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.Task_Day;
import com.example.myapplication.Persistence.Data.TaskDayPersistenceDB;

import java.util.ArrayList;
import java.util.List;

public class Access_TD extends AppCompatActivity {
    List<Task_Day> listofTD;
    TaskDayPersistenceDB taskDayPersistenceDB;
    public Access_TD(){
        listofTD = new ArrayList<>();
        taskDayPersistenceDB = new TaskDayPersistenceDB();
    }
    public Access_TD(TaskDayPersistenceDB n){
        taskDayPersistenceDB = n;
        listofTD = taskDayPersistenceDB.getAllTD();
    }
    public void setDeadline(Task_Day task, String start, String end){
        taskDayPersistenceDB.setDeadline(task,start,end);
    }

    public void addTaskDayP(Task_Day newItem){
        taskDayPersistenceDB.addTaskDayP(newItem);
    }

    public List<Task_Day> getAllTD() {
        listofTD = taskDayPersistenceDB.getAllTD();
        return listofTD;
    }
}
