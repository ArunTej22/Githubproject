package jan12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Annotation1 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(5000);
		Reporter.log("Running in BeforeTest",true);
	}
	@Test(priority=2,enabled=true)
	public void pbanking()throws Throwable
	{
		driver.findElement(By.xpath("//a[starts-with(@href,'pers')]")).click();
		Thread.sleep(5000);
		Reporter.log("Executing Pbanking Test case",true);
	}
	@Test(priority=0,enabled=true)
	public void ibanking()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Thread.sleep(5000);
		Reporter.log("Executing ibanking Test case",true);
	}
	@Test(priority=1,enabled=false)
	public void cbanking()throws Throwable
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Thread.sleep(5000);
		Reporter.log("Executing cbanking Test case",true);
	}

	@AfterTest
	public void afterTest()throws Throwable
	{
		Thread.sleep(5000);
		driver.close();
		Reporter.log("Running AfterTest",true);
	}

}

