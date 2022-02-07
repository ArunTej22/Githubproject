package jan22;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertiesFile {
	WebDriver driver;
	Properties config;
	@BeforeTest
	public void setup() throws Throwable
	{
		config = new Properties();
		config.load(new FileInputStream("F:\\AutomationTesting\\TestNG_Framework\\opencart.properties"));
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(config.getProperty("Url"));
		Thread.sleep(4000);		
	}
	@Test
	public void VerifyRegister() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("fname"))).sendKeys(config.getProperty("enterfname"));
		driver.findElement(By.xpath(config.getProperty("Lname"))).sendKeys(config.getProperty("enterlname"));
		driver.findElement(By.xpath(config.getProperty("mail"))).sendKeys(config.getProperty("enteremail"));
		driver.findElement(By.xpath(config.getProperty("phone"))).sendKeys(config.getProperty("enterphone"));
		driver.findElement(By.xpath(config.getProperty("password"))).sendKeys(config.getProperty("enterpassword"));
		driver.findElement(By.xpath(config.getProperty("cpassword"))).sendKeys(config.getProperty("entercpassword"));
		driver.findElement(By.xpath(config.getProperty("checkbox"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(config.getProperty("continuebtn"))).click();
		Thread.sleep(4000);		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}		
}
