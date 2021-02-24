package com.example.myapplication.Persistence;
import com.example.myapplication.Object.Day;
import java.util.List;

public interface Day_persistence {
    Day getDay();
    void setStartTime(Day target, String newTime);
    void setEndTime(Day target, String newTime);
    void setMonth(Day target, int newMonth);
    void setDay(Day target, int newDay);
    void deleteDay(Day target);

    List<Day>getAllDay();
}
