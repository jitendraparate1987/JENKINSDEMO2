package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import Utils.RetryListener;
import Utils.SuiteListener;

@Listeners(SuiteListener.class)
public class BasicTest1 extends BaseTest{
	
	
@Test(retryAnalyzer = RetryListener.class)
public void Method1() {

	System.out.println("Inside Method 1\n");
	driver.get("https://google.co.in");
	Assert.fail();
	
}

@Test
public void Method2() {
	
	System.out.println("Inside Method 2\n");
	driver.get("https://facebook.com");
}

@Test
public void Method3() {
	
	System.out.println("Inside Method 3\n");
}


}
