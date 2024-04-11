package BaseClasses;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	

@BeforeSuite
@Parameters("browser")
public void BeforeSuiteMethod(String browser) {
	
	if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	System.out.println("Before Suite");}
	
	if(browser.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();)
		driver = new EdgeDriver();
		
		System.out.println("Before Suite");}
	
	}



@BeforeTest
public void BeforeTestMethod() {
	
	System.out.println("Before Test\n");
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "JitendraExtentReport.html");
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	sparkReporter.config().setTheme(Theme.STANDARD);
	extent.setSystemInfo("HostName","RHEL8");
	extent.setSystemInfo("Username","root");
	sparkReporter.config().setDocumentTitle("Automation Report");
	sparkReporter.config().setReportName("Automation Test Results");
	
}

@AfterTest
public void AfterTestMethod() {
	
	System.out.println("After Test\n");
}

@BeforeMethod
public void BeforeMethodMethod(ITestResult result) {
	
	System.out.println("Before Method\n");
	logger = extent.createTest(result.getMethod().getMethodName());
}

@AfterMethod
public void AfterMethodMethod(ITestResult result) {
	
	System.out.println("After Method\n");
	
	if(result.getStatus() == ITestResult.FAILURE) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
		logger.addScreenCaptureFromPath(System.getProperty("user.dir")+File.separator+"screenshots" +File.separator + result.getMethod().getMethodName()+".jpg");
		
		}else if(result.getStatus() == ITestResult.SKIP) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "- Test Case Skipped", ExtentColor.ORANGE));
		
	} else if(result.getStatus() == ITestResult.SUCCESS) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- Test Case Passed", ExtentColor.GREEN));
		
	}
	
}

@BeforeClass
public void beforeClassMethod() {
	
	System.out.println("Before Class\n");
	
}

@AfterClass
public void afterClassMethod() {
	
	System.out.println("After Class\n");
	
}



@AfterSuite(alwaysRun=true)
public void AfterSuiteMethod() {
	
System.out.println("After Suite");	
driver.close();
extent.flush();
	
}

}
