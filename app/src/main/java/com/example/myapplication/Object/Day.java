package com.example.myapplication.Object;

import java.util.Calendar;

public class Day {
    private int day;
    private int month;
    private int year;
    //private int startTime;
    //private int endTime;

    public Day(int year, int month, int day)throws typeInException{
        if(day>31){
            throw new typeInException("newDay can not bigger than 31");
        }else if(day<=0){
            throw new typeInException("newDay can not smaller than 1");
        }else if(month<=0){
            throw new typeInException("newMonth can not smaller than 1");
        }else if(month>12){
            throw new typeInException("newMonth can not bigger than 12");
        }else if(year<0){
            throw new typeInException("newYear can not be negative");
        }


        this.day = day;
        this.month = month;
        this.year = year;
        //this.startTime = startTime;
        //this.endTime = endTime;
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
    /*public int getStartTime(){
        return this.startTime;
    }*/

    /*get the endTime
    public int getEndTime(){
        return this.endTime;
    }*/

    /*set startTime
    public void changeStartTime(int newTime){
        this.startTime=newTime;
    }*/

    /*set endTime
    public void changeEndTime(int newTime){
        this.endTime=newTime;
    }*/



    //set day
    public void changeDay(int newDay) throws typeInException {
        if(newDay>31){
            throw new typeInException("newDay can not bigger than 31");
        }else if(newDay<=0){
            throw new typeInException("newDay can not smaller than 1");
        }
        this.day = newDay;

    }

    //set month
    public void changeMonth(int newMonth)throws typeInException{
        if(newMonth<=0){
            throw new typeInException("newMonth can not smaller than 1");
        }else if(newMonth>12){
            throw new typeInException("newMonth can not bigger than 12");}

        this.month = newMonth;
    }

    //set year
    public void changeYear(int newYear)throws typeInException{
        if(year<0){
            throw new typeInException("newYear can not be negative");
        }
        this.year = newYear;
    }

    public class typeInException extends Exception{
        public typeInException(){
            super("this is a type in exception.");
        }
        public typeInException(String type){
            super("this is a type in exception"+type);
        }

    }

}

