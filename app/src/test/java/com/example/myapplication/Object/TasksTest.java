package com.example.myapplication.Object;

import org.junit.Test;

import static org.junit.Assert.*;

public class TasksTest {

    @Test
    public void testTasks ()throws Tasks.InPutNull
    {
        Tasks newTask;
        Tasks oldTask;

        System.out.println("\nStarting testTasks...");

        oldTask = new Tasks(0, "Task 0", "Task 0 Description","2021-02-24");
        newTask = new Tasks(1, "Task 1", "Task 1 Description","2021-02-25");
        newTask.setTaskTitle("What's new");
        newTask.setTaskDescription("Some changes here");
        newTask.setTaskDate("2021-02-26");
        newTask.setStatus("To Do");

        assertNotNull(oldTask);
        assertNotNull(newTask);
        //assertEquals(0,newTask.getCurrTaskId());
        assertEquals("What's new",newTask.getTaskTitle());
        assertEquals("Some changes here",newTask.getTaskDescription());
        assertEquals("2021-02-26",newTask.getTaskDate());
        assertEquals("To Do",newTask.getStatus());
        assertFalse(newTask.checkForSame(oldTask));

        System.out.println("Finished testTasks...");

    }
}