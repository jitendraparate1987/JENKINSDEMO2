package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import Utils.RetryListener;
import Utils.SuiteListener;

@Listeners(SuiteListener.class)
public class BasicTest2 extends BaseTest{
	
	
@Test(retryAnalyzer=RetryListener.class)
public void Method4() {

	System.out.println("Inside Method 4\n");
	driver.get("https://www.amazon.in/");
	Assert.fail();
}

@Test
public void Method5() {
	
	System.out.println("Inside Method 5\n");
	
}

@Test
public void Method6() {
	
	System.out.println("Inside Method 6\n");
}


}
