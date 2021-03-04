package com.example.myapplication.Persistence;
import com.example.myapplication.Object.Day;
import java.util.List;

public interface Day_persistence {
    //void setStartTime(Day target, int newTime);
    //void setEndTime(Day target, int newTime);
    void setMonth(Day target, int newMonth)throws Day.typeInException;
    void setDay(Day target, int newDay)throws Day.typeInException;
    void setYear(Day target, int newYear)throws Day.typeInException;
    void deleteDay(Day target);
    void addDay(Day target);
    Day getDay(Day day);

    List<Day>getAllDay();
}
