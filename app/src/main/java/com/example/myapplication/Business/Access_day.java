package com.example.myapplication.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Day_persistence;
import com.example.myapplication.application.Service;

public class Access_day extends AppCompatActivity {
    private List<Day>allDays;
    private Day_persistence DayPersistence;

    public Access_day(){
        allDays = new ArrayList<>();
        DayPersistence = Service.getDayPersistence();
    }

    public Access_day(Day_persistence DayPersistence){
        this.DayPersistence = DayPersistence;
        allDays = DayPersistence.getAllDay();
    }

    /*void setStartTime(Day target, int newTime){
        DayPersistence.setStartTime(target,newTime);
    };*/
    /*void setEndTime(Day target, int newTime){
        DayPersistence.setEndTime(target,newTime);
    };*/
    void setMonth(Day target, int newMonth){
        DayPersistence.setMonth(target,newMonth);
    };
    void setDay(Day target, int newDay){
        DayPersistence.setDay(target,newDay);
    };
    void setYear(Day target, int newYear){
        DayPersistence.setYear(target,newYear);
    };
    void deleteDay(Day target){
        DayPersistence.deleteDay(target);
    };
    void addDay(Day target){
        DayPersistence.addDay(target);
    };

    List<Day>getAllDay(){
        allDays=DayPersistence.getAllDay();
        return allDays;
    };


}
