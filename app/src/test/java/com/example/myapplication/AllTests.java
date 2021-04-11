package com.example.myapplication;
import com.example.myapplication.Persistence.FakeDBUnitTest;
import com.example.myapplication.Persistence.HSQLDBUnitTest;
import com.example.myapplication.business.AccessTaskTest;
import com.example.myapplication.objects.TaskTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TaskTest.class,
        AccessTaskTest.class,
        FakeDBUnitTest.class,
        HSQLDBUnitTest.class

})
public class AllTests{

}

