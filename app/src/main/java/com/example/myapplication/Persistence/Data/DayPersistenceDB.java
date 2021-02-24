package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Day_persistence;

import java.util.ArrayList;
import java.util.List;

public class DayPersistenceDB implements Day_persistence {
    List<Day> dayList;
    public DayPersistenceDB(){
        dayList = new ArrayList<>();
    }

    public void addDay(Day target){
        dayList.add(new Day(3,3,2021,"12:00","14:00"));
        dayList.add(new Day(3,3,2021,"10:00","11:00"));
    }
    @Override
    public Day getDay() {
        return null;
    }

    @Override
    public void setStartTime(Day target, String newTime) {

    }

    @Override
    public void setEndTime(Day target, String newTime) {

    }

    @Override
    public void setMonth(Day target, int newMonth) {

    }

    @Override
    public void setDay(Day target, int newDay) {

    }

    @Override
    public void deleteDay(Day target) {

    }

    @Override
    public List<Day> getAllDay() {
        return null;
    }
}
