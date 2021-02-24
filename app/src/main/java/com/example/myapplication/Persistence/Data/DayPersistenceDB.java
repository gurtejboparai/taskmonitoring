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
        dayList.add(new Day(3,3,2021));
        dayList.add(new Day(3,3,2021));
        dayList.add(new Day(4,3,2021));
        dayList.add(new Day(4,3,2021));
        dayList.add(new Day(4, 3,2021));
        dayList.add(new Day(5,3,2021));
    }

    /*@Override
    public void setStartTime(Day target, int newTime) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeStartTime(newTime);
            this.dayList.set(index,target);
        }
    }*/

    /*@Override
    public void setEndTime(Day target, int newTime) {
        int index = this.dayList.indexOf(target);
        if(index>=0){
            target.changeEndTime(newTime);
            this.dayList.set(index,target);
        }
    }*/

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
