package com.example.myapplication;
import com.example.myapplication.Business.AccessDayTest;
import com.example.myapplication.Business.AccessTaskTest;
import com.example.myapplication.Object.DayTest;
import com.example.myapplication.Object.TaskDayTest;
import com.example.myapplication.Object.TaskTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DayTest.class,
        TaskTest.class,
        TaskDayTest.class,
        AccessTaskTest.class,
        AccessDayTest.class
        //Access_TD.class

})
public class AllTests{

}
