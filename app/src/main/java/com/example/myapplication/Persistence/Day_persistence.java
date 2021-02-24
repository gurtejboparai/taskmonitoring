package com.example.myapplication.Persistence;
import com.example.myapplication.Object.Day;

public interface Day_persistence {
    Day getDay();
    void setStartTime(Day target, int newTime);
    void setEndTime(Day target, int newTime);
    void setMonth(Day target, int newMonth);
    void setDay(Day target, int newDay);
    void deleteDay(Day target);
}
