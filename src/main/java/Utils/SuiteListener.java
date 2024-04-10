package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseClasses.BaseTest;

public class SuiteListener extends BaseTest implements ITestListener {
	
	@Override
    public void onTestStart(ITestResult result) {
        // Code to execute before each test method starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute after each test method succeeds
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute after each test method fails
        System.out.println("Test failed: " + result.getName());
        TakesScreenshot screenshotDriver = (TakesScreenshot)driver;

        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

        File destinationPath = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName()+".jpg");

        try {
        
            FileUtils.copyFile(screenshot, destinationPath);
        
        } catch (IOException e) {
        
        	e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute after each test method is skipped
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test method in a <test> tag is run
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all test methods in a <test> tag have run
    }

}
