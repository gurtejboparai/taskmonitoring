package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Data.DayPersistenceDB;
import com.example.myapplication.Persistence.Day_persistence;
import com.example.myapplication.application.Service;

public class Access_day extends AppCompatActivity {
    private List<Day>allDays;
    private DayPersistenceDB DayPersistence;

    public Access_day(){
        allDays = new ArrayList<>();
        DayPersistence = new DayPersistenceDB();
    }

    public Access_day(DayPersistenceDB DB){
        this.DayPersistence = DB;
        allDays = DB.getAllDay();
    }
    public Day getDay(Day day){
        return this.DayPersistence.getDay(day);
    }

    /*void setStartTime(Day target, int newTime){
        DayPersistence.setStartTime(target,newTime);
    };*/
    /*void setEndTime(Day target, int newTime){
        DayPersistence.setEndTime(target,newTime);
    };*/
    void setMonth(Day target, int newMonth){
        try {
            DayPersistence.setMonth(target, newMonth);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void setDay(Day target, int newDay){
        try{
        DayPersistence.setDay(target,newDay);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void setYear(Day target, int newYear){
        try{
        DayPersistence.setYear(target,newYear);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void deleteDay(Day target){
        DayPersistence.deleteDay(target);
    }
    void addDay(Day target){
        DayPersistence.addDay(target);
    }

    List<Day>getAllDay(){
        allDays=DayPersistence.getAllDay();
        return allDays;
    }


}
