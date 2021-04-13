package com.example.myapplication.Persistence;
import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.data.TaskPersistenceDB;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;
import com.example.myapplication.utils.TestUtils;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
public class HSQLDBUnitTest {
    @Test
    public void TesInitializeDatabase() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        assertNotNull("The database should not be null",taskPersistence.getAllTasks());
    }

    @Test
    public void TestAddTask() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        Task newTask = new Task(10, "Call the doctor","setup appointment for Kevin","2021-05-10");
        taskPersistence.addTask(newTask);
        Task cTask = taskPersistence.getTask(10);
        assertEquals(cTask.getCurrTaskId(),newTask.getCurrTaskId());
        assertEquals(cTask.getTaskDescription(), newTask.getTaskDescription());
    }

    @Test
    public void TestEditTask() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        Task newTask = new Task(10, "Call the doctor","setup appointment for Kevin","2021-05-10");
        taskPersistence.addTask(newTask);
        Task editTask = new Task(10, "new Title", "new Description", "2021-03-02");
        taskPersistence.editTask(editTask);
        assertNotEquals(newTask.getTaskDescription(),editTask.getTaskDescription());
        assertNotEquals(newTask.getTaskTitle(),editTask.getTaskTitle());
    }

    @Test
    public void TestdeleteTask() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        Task newTask = new Task(10, "Call the doctor","setup appointment for Kevin","2021-05-10");
        taskPersistence.addTask(newTask);
        Task dTask = taskPersistence.deleteTask(newTask);
        assertEquals(newTask.getTaskTitle(),dTask.getTaskTitle());
        assertEquals(newTask.getTaskDescription(),dTask.getTaskDescription());
    }

    @Test
    public void TestEditDate() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        Task newTask = new Task(10, "Call the doctor","setup appointment for Kevin","2021-05-10");
        taskPersistence.addTask(newTask);
        String date = newTask.getTaskDate();
        taskPersistence.setTaskDate(newTask, "2021-05-04");
        Task cTask = taskPersistence.getTask(10);
        assertNotEquals(cTask.getTaskDate(),date);
    }

    @Test
    public void TestGetAllTask() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistenceHSQLDB taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        List aList = taskPersistence.getAllTasks();
        assertNotNull(aList);
    }

}
