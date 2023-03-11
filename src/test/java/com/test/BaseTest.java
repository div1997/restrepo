package com.test;

import com.api.utills.Readandwriteutills;
import com.api.utills.Reportutills;
import com.api.utills.logreportutills;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {


    @Test
    public void logger(Method m)
    {
        Reportutills.creatTest(m.getName());
        logreportutills.info_message("yes yesy");
    }
    /*@BeforeSuite
    public void setsuite()
    {
        Reportutills.initreport();

    }
    @BeforeMethod
    public void setuptestmethod(Method m)
    {
        Reportutills.creatTest(m.getName());
    }
    @AfterMethod
    public void setupaftermethod(ITestResult result)
    {
        if(!result.isSuccess())
        logreportutills.failed(String.valueOf(result.getThrowable()));
    }
    @AfterSuite

    public void setupaftersuite()
    {
     Reportutills.teardownreport();
    }*/
}
