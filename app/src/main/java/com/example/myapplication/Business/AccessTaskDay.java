package com.example.myapplication.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Object.TaskDay;
import com.example.myapplication.Persistence.Data.TaskDayPersistenceDB;

import java.util.ArrayList;
import java.util.List;

public class AccessTaskDay extends AppCompatActivity {
    List<TaskDay> listofTD;
    TaskDayPersistenceDB taskDayPersistenceDB;
    public AccessTaskDay(){
        listofTD = new ArrayList<>();
        taskDayPersistenceDB = new TaskDayPersistenceDB();
    }
    public AccessTaskDay(TaskDayPersistenceDB n){
        taskDayPersistenceDB = n;
        listofTD = taskDayPersistenceDB.getAllTD();
    }
    public void setDeadline(TaskDay task, String start, String end){
        taskDayPersistenceDB.setDeadline(task,start,end);
    }

    public void addTaskDayP(TaskDay newItem){
        taskDayPersistenceDB.addTaskDayP(newItem);
    }
    public List<TaskDay> getTaskDay(int td){
        return taskDayPersistenceDB.getTaskDay(td);
    }

    public List<TaskDay> getAllTD() {
        listofTD = taskDayPersistenceDB.getAllTD();
        return listofTD;
    }
}
