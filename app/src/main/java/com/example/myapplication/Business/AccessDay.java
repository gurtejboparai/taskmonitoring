package com.example.myapplication.Business;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Data.DayPersistenceDB;
import com.example.myapplication.Persistence.DayPersistence;
import com.example.myapplication.application.Service;

public class AccessDay extends AppCompatActivity {
    private List<Day>allDays;
    private DayPersistenceDB dayPersistence;

    public AccessDay(){
        allDays = new ArrayList<>();
        dayPersistence = new DayPersistenceDB();
    }

    public AccessDay(DayPersistenceDB DB){
        this.dayPersistence = DB;
        allDays = DB.getAllDay();
    }
    public Day getDay(Day day){
        return this.dayPersistence.getDay(day);
    }

    /*void setStartTime(Day target, int newTime){
        DayPersistence.setStartTime(target,newTime);
    };*/
    /*void setEndTime(Day target, int newTime){
        DayPersistence.setEndTime(target,newTime);
    };*/
    void setMonth(Day target, int newMonth){
        try {
            dayPersistence.setMonth(target, newMonth);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void setDay(Day target, int newDay){
        try{
            dayPersistence.setDay(target,newDay);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void setYear(Day target, int newYear){
        try{
            dayPersistence.setYear(target,newYear);
        }catch (Day.typeInException e){
            System.out.println(e.getMessage());
        }
    }
    void deleteDay(Day target){
        dayPersistence.deleteDay(target);
    }
    void addDay(Day target){
        dayPersistence.addDay(target);
    }

    List<Day>getAllDay(){
        allDays=dayPersistence.getAllDay();
        return allDays;
    }


}
