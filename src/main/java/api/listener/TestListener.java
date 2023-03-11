package api.listener;

import api.annotation.frameworkannotation;
import com.api.utills.Reportutills;
import com.api.utills.logreportutills;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener
{
    @Override
    public void onStart(ISuite suite)
    {
        Reportutills.initreport();
    }
    @Override
    public void onFinish(ISuite suite)
    {
        Reportutills.teardownreport();
    }
    @Override
    public void onTestStart(ITestResult result)
    {
        Reportutills.creatTest(result.getName());
        String [] author =  result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(frameworkannotation.class).author();
        logreportutills.assignauthor(author);
        String [] category =  result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(frameworkannotation.class).category();
        logreportutills.assigncategory(category);

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        logreportutills.info_message("test is pass");
        Reportutills.creatTest(result.getName());
        logreportutills.pass(result.getName() +" is success");
        logreportutills.pass(String.valueOf(result.getStatus()));



    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        // not implemented
            logreportutills.info_message("test failed");
            logreportutills.failed(String.valueOf(result.getThrowable()));
    }



}
