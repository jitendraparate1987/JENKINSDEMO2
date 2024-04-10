package Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import Utils.SuiteListener;


@Listeners(SuiteListener.class)
public class BasicTest3 extends BaseTest{
	
	
@Test
public void Method7() {

	System.out.println("Inside Method 7\n");
	
}

@Test
public void Method8() {
	
	System.out.println("Inside Method 8\n");
	
}

@Test
public void Method9() {
	
	System.out.println("Inside Method 9\n");
}


}
