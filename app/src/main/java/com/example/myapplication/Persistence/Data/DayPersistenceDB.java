package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.DayPersistence;

import java.util.ArrayList;
import java.util.List;

public class DayPersistenceDB implements DayPersistence {
    List<Day> dayList;
    public DayPersistenceDB(){
        this.dayList = new ArrayList<>();
    }

    public void addDays()throws Day.typeInException{

        dayList.add(new Day(2021,3,3));
        dayList.add(new Day(2021,3,3));
        dayList.add(new Day(2021,3,4));
        dayList.add(new Day(2021,3,4));
        dayList.add(new Day(2021, 3,4));
        dayList.add(new Day(2021,3,5));

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
    public void setMonth(Day target, int newMonth)throws Day.typeInException {
        int index = this.dayList.indexOf(target);
        if(index>=0){
                target.changeMonth(newMonth);
                 this.dayList.set(index,target);
        }
    }

    @Override
    public void setDay(Day target, int newDay) throws Day.typeInException{
        int index = this.dayList.indexOf(target);
        if(index>=0){
                target.changeDay(newDay);
            this.dayList.set(index,target);
        }
    }

    @Override
    public void setYear(Day target, int newYear)throws Day.typeInException {
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
        this.dayList.add(target);
    }

    @Override
    public Day getDay(Day day){
        int index = this.dayList.indexOf(day);
        if(index>=0){
            return dayList.get(index);
        }
        else return null;
    }

    @Override
    public List<Day> getAllDay() {
        return this.dayList;
    }


}
