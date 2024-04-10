package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import BaseClasses.BaseTest;

public class RetryListener extends BaseTest implements IRetryAnalyzer {

	
	private int retryCount = 0;
    private static final int maxRetryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
	}

}
