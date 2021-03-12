package com.example.myapplication;
import com.example.myapplication.Business.AccessTaskTest;
import com.example.myapplication.Object.TaskTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TaskTest.class,
        AccessTaskTest.class,

})
public class AllTests{

}
