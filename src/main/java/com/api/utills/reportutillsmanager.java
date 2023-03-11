package com.api.utills;

import com.aventstack.extentreports.ExtentTest;

public final class reportutillsmanager
{
    private reportutillsmanager () {}
    private  static ThreadLocal<ExtentTest> etest = new ThreadLocal<>();
    static void setExtenttest(ExtentTest test)
    {

        etest.set(test);
    }
     static  ExtentTest getTest()
    {
        return etest.get();
    }

    public static void unload()
{
    etest.remove();
}


}
