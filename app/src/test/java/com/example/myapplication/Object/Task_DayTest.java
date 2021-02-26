package com.example.myapplication.Object;

import android.content.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Task_DayTest {
    @Test
    public void testTD(){
        Task_Day taskTD;
        int numOfTasks =0;
        System.out.println("Start test for task_day object");
        taskTD = new Task_Day(new Tasks(numOfTasks +1, "Call the doctor","setup appointment for Kevin","2021-03-02"));
        String OldStart = taskTD.getStartTime();
        String OldEnd = taskTD.getEndTime();
        taskTD.setDeadline("4:00","5:00");
        if(taskTD.getStartTime()!=OldStart && taskTD.getEndTime()!=OldEnd)
            System.out.println("Function work");
        System.out.println("Done Test");
    }
}