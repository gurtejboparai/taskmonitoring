package com.example.myapplication;

import com.example.myapplication.business.AccessTaskIT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessTaskIT.class,
})
public class IntegrationTest {
}

