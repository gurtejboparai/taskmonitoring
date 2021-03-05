package com.example.myapplication.Object;

import org.junit.Test;

public class TaskDayTest {
    @Test
    public void testTD() throws Day.typeInException {
        int numOfTasks =0;
        System.out.println("Start test for task_day object");
        TaskDay taskTD;
        taskTD = new TaskDay(new Task(numOfTasks + 1, "Call the doctor", "setup appointment for Kevin", "2021-03-02"));
        String OldStart = taskTD.getStartTime();
        String OldEnd = taskTD.getEndTime();
        taskTD.setDeadline("4:00","5:00");
        if(!taskTD.getStartTime().equals(OldStart) && !taskTD.getEndTime().equals(OldEnd))
            System.out.println("Function work");
        System.out.println("Done Test");
    }
}