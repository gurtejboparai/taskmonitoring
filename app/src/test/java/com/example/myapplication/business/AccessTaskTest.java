package com.example.myapplication.business;

import com.example.myapplication.application.Service;
import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.data.TaskPersistenceDB;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class AccessTaskTest {

    //private Access_task accessTaskMock;
    private TaskPersistence taskPersistence;
    private TaskPersistenceDB taskDB;
    private AccessTask accessTaskDB;


    @Before
    public void setUp(){
        taskDB = new TaskPersistenceDB();
        taskDB.getAllTasks();
        accessTaskDB = new AccessTask(taskDB);

        //taskPersistence = mock(Task_persistence.class);
        //accessTaskMock = new Access_task(taskPersistence);

    }

    @Test
    public void testAddNullTask(){

        System.out.println("\nStarting TestAccessTask: add null task");

        Task addTask = accessTaskDB.addTask(null);

        assertNull(addTask);

        System.out.println("Finished TestAccessTask...");

    }

    @Test
    public final void testAddNotNullTask(){

        System.out.println("\nStarting TestAccessTask...");

        int taskId = taskDB.getNewTaskId();

        String title = "3350 Due";
        String description = "Iteration 1";
        String date = "2021-02-26";

        Task newTask = new Task(taskId, title, description, date);

        Task addTask = accessTaskDB.addTask(newTask);

        assertNotNull(addTask);
        assertEquals(taskId, addTask.getCurrTaskId());
        assertEquals("3350 Due",newTask.getTaskTitle());
        assertEquals("Iteration 1",newTask.getTaskDescription());
        assertEquals("2021-02-26",newTask.getTaskDate());

        System.out.println("Finished AccessTaskTest...");
    }
    @Test
    public void getTask(){
        String title = "3350 Due";
        String description = "Iteration 1";
        String date = "2021-02-26";

        Task newTask = new Task(0, title, description, date);
        assertNotNull(newTask);
    }

    @Test
    public void testTaskUpdate()
    {
        System.out.println("\nStarting testTaskUpdate: update task we already have...");

        Task taskNeedUpdate = accessTaskDB.getTask(0);
        assertNotNull(taskNeedUpdate);

        String oldTitle = taskNeedUpdate.getTaskTitle();
        String oldDescription = taskNeedUpdate.getTaskDescription();
        String oldDate = taskNeedUpdate.getTaskDate();

        String newTitle = "i am a new title";
        String newDescription = "i am a new description";

        Task updateTask = new Task(taskNeedUpdate.getCurrTaskId(), newTitle, newDescription, oldDate);

        accessTaskDB.editTask(updateTask);
        taskNeedUpdate = accessTaskDB.getTask(0);

        assertNotEquals(oldTitle, taskNeedUpdate.getTaskTitle());
        assertNotEquals(oldDescription, taskNeedUpdate.getTaskDescription());
        assertEquals(newTitle, taskNeedUpdate.getTaskTitle());


        System.out.println("\nFinishing testTaskUpdate...");
    }

    @Test
    public final void testRemoveNull()
    {
        System.out.println("\nStarting testRemoveNull...");

        Task removeTask = accessTaskDB.deleteTask(null);

        assertNull(removeTask);

        System.out.println("Finished testRemoveNull...");
    }

    @Test
    public void testRemoveNotNull()
    {
        System.out.println("\nStarting testRemoveNotNull...");

        int taskId = 2;

        Task taskNeedDel= accessTaskDB.getTask(taskId);

        assertNotNull(taskNeedDel);
        assertEquals(taskId, taskNeedDel.getCurrTaskId());

        Task deleteTask = accessTaskDB.deleteTask(taskNeedDel);

        assertEquals(taskId, deleteTask.getCurrTaskId());

        Task checkTask = accessTaskDB.getTask(2);
        //assertNotNull(checkTask);

        System.out.println("Finished testRemoveNotNull...");
    }

    @Test
    public void testGetAllTasks()
    {
        System.out.println("\nStarting testGetAllAds...");

        List<Task> tasks = accessTaskDB.getAllTasks();

        assertNotNull(tasks);

        System.out.println("Finished testGetAllAds...");
    }

    @Test
    public void testSetTaskDate(){

        System.out.println("\nStarting testSetTaskDate...");

        Task newTask = accessTaskDB.getTask(3);

        accessTaskDB.setTaskDate(newTask, "2021-03-26");

        assertNotNull(newTask);

        System.out.println("Finished testSetTaskDate...");
    }

    @Test
    public void testIfSame(){

        System.out.println("\nStarting testIfSame...");

        Task taskOne = accessTaskDB.getTask(4);
        Task taskTwo = accessTaskDB.getTask(5);

        assertNotNull(taskOne);
        assertNotNull(taskTwo);

        assertNotEquals(taskOne.getTaskTitle(), taskTwo.getTaskTitle());
        assertNotEquals(taskOne.getTaskDescription(), taskTwo.getTaskDescription());
        assertNotEquals(taskOne.getTaskDate(), taskTwo.getTaskDate());

        boolean a =accessTaskDB.checkForSame(taskOne,taskTwo);
        assertFalse(a);

        System.out.println("Finished testIfSame...");
    }

}