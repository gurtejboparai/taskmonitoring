package com.example.myapplication.Object;

import java.util.Calendar;

public class Day {
    private int day;
    private int month;
    private int year;
    private int startTime;
    private int endTime;

    public Day(int day, int month, int year, int startTime, int endTime){
        this.day = day;
        this.month = month;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //get the day
    public int getDay(){
        return this.day;
    }

    //get the month
    public int getMonth(){
        return this.month;
    }

    //get the year
    public int getYear(){
        return this.year;
    }

    //get the startTime
    public int getStartTime(){
        return this.startTime;
    }

    //get the endTime
    public int getEndTime(){
        return this.endTime;
    }

}

