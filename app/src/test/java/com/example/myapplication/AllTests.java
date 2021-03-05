package com.example.myapplication;
import com.example.myapplication.Business.Access_TD;
import com.example.myapplication.Business.Access_dayTest;
import com.example.myapplication.Business.Access_taskTest;
import com.example.myapplication.Object.DayTest;
import com.example.myapplication.Object.Task_DayTest;
import com.example.myapplication.Object.TasksTest;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DayTest.class,
        TasksTest.class,
        Task_DayTest.class,
        Access_taskTest.class,
        Access_dayTest.class
        //Access_TD.class

})
public class AllTests{

}
