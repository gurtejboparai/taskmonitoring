package com.example.myapplication.Object;

import org.junit.Test;

import static org.junit.Assert.*;

public class TasksTest {

    @Test
    public void testTasks()
    {
        Tasks newTask;

        System.out.println("\nStarting testTasks...");

        newTask = new Tasks(0, "Task 1", "Task 1 Description","2021-02-25");
        newTask.setTaskTitle("What's new");
        newTask.setTaskDescription("Some changes here");
        newTask.setTaskDate("2021-02-26");
        newTask.setStatus("To Do");

        assertNotNull(newTask);
        assertEquals(0,newTask.getCurrTaskId());
        assertEquals("Task 1",newTask.getTaskTitle());
        assertEquals("Task 1 Description",newTask.getTaskDescription());
        assertEquals("2021-02-25",newTask.getTaskDate());
        //assertTrue("on going".equals(newTask.getStatus()));

        System.out.println("Finished testTasks...");

    }
}