package com.api.utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;


public final class Reportutills
{
    private Reportutills () {}
private static ExtentReports extest;
      private static ExtentTest test; // it is not thread safe now


    public static void initreport()
    {
       extest  = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("testresult.html");
        extest.attachReporter(spark);

    }

    public static void teardownreport()
    {
        extest.flush();
    }

    public static void creatTest(String name)
    {
        test =extest.createTest(name);
        reportutillsmanager.setExtenttest(test);
    }



}
