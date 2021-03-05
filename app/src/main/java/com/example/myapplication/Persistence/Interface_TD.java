package com.example.myapplication.Persistence;

import com.example.myapplication.Object.Task_Day;

import java.util.List;

public interface Interface_TD {
    void setDeadline(Task_Day td, String start, String end);
    Task_Day getTaskDay(Task_Day target);
    List<Task_Day>getAllTD();
}
