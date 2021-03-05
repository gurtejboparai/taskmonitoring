package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Task_Day;

import java.util.List;

public interface Interface_TD {
    void setDeadline(Task_Day td, String start, String end);
    List<Task_Day> getTaskDay(int TaskID);
    List<Task_Day>getAllTD();
}
