package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Day_persistence;

import java.util.ArrayList;
import java.util.List;

public class DayPersistenceDB implements Day_persistence {
    List<Day> dayList;
    public DayPersistenceDB(){
        this.dayList = new ArrayList<>();
    }

    public void addDays(Day target){
        dayList.add(new Day(3,3,2021,"12:00","14:00"));
        dayList.add(new Day(3,3,2021,"10:00","11:00"));
        dayList.add(new Day(4,3,2021,"9:00","10:00"));
        dayList.add(new Day(4,3,2021,"14:00","15:00"));
        dayList.add(new Day(4, 3,2021,"17:00","20:00"));
        dayList.add(new Day(5,3,2021,"9:00","11:00"));
    }

    @Override
    public void setStartTime(Day target, String newTime) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeStartTime(newTime);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void setEndTime(Day target, String newTime) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeEndTime(newTime);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void setMonth(Day target, int newMonth) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeMonth(newMonth);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void setDay(Day target, int newDay) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeDay(newDay);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void setYear(Day target, int newYear) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeYear(newYear);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void deleteDay(Day target) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            this.dayList.remove(target);
        }
    }

    @Override
    public void addDay(Day target) {
        if(!this.dayList.contains(target))
            this.dayList.add(target);
    }

    @Override
    public List<Day> getAllDay() {
        return this.dayList;
    }
}
