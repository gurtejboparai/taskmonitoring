package com.example.myapplication.business;

import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;
import com.example.myapplication.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import static junit.framework.TestCase.assertNull;

public class AccessTaskIT {
    private AccessTask accessTask;

    @Before
    public void setUp() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistence taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        this.accessTask=new AccessTask((TaskPersistenceHSQLDB) taskPersistence);
    }
    @Test
    public void testLAddNullTask(){
        Task addTask = accessTask.addTask(null);
        assertNull(addTask);
    }

}
