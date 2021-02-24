package com.example.myapplication.Persistence;
import com.example.myapplication.Object.Day;
import java.util.List;

public interface Day_persistence {
    void setStartTime(Day target, int newTime);
    void setEndTime(Day target, int newTime);
    void setMonth(Day target, int newMonth);
    void setDay(Day target, int newDay);
    void setYear(Day target, int newYear);
    void deleteDay(Day target);
    void addDay(Day target);

    List<Day>getAllDay();
}
