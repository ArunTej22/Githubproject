package jan22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
WebDriver driver;
ExtentReports report;
ExtentTest logger;
@BeforeTest
public void generateReport()
{
	//define path to generate html reports
	report= new ExtentReports("./Reports/Demo.html");
}
@BeforeMethod
public void setUp()throws Throwable
{
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://google.com");
	Thread.sleep(3000);
}
@Test
public void passTest()
{
	logger =report.startTest("My Test Case Pass");
	logger.assignAuthor("Ranga");
	String expected ="Google";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(expected))
	{
		logger.log(LogStatus.PASS, "Title is Matching::"+expected+"     "+Actual);
	}
	else
	{
		logger.log(LogStatus.FAIL, "Title is Not Matching::"+expected+"     "+Actual);
	}
}
@Test
public void failTest()
{
	logger =report.startTest("My Test Case Fail");
	logger.assignAuthor("Ranga");
	String expected ="Gamil";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(expected))
	{
		logger.log(LogStatus.PASS, "Title is Matching::"+expected+"     "+Actual);
	}
	else
	{
		logger.log(LogStatus.FAIL, "Title is Not Matching::"+expected+"     "+Actual);
	}	
}
@AfterMethod
public void closeReports()
{
	report.endTest(logger);
	report.flush();
	driver.close();
}
}