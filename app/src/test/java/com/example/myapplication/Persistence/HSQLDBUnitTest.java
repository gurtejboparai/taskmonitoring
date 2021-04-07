package com.example.myapplication.Persistence;
import com.example.myapplication.persistence.TaskPersistence;
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
    public void TestAddTask(){

    }

}
