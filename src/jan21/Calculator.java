package jan21;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calculator {
	
	WebDriver driver;
	String input = "f://calculation.xlsx";
	String output = "f://resultcal.xlsx";
	
	@BeforeTest
	public void setup()
	{
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	}
	@Test
	public void test() throws Throwable
	{
		FileInputStream fi = new FileInputStream(input);
		Workbook  wb = WorkbookFactory.create(fi);
		Sheet ws = wb.getSheetAt(0);
		int rc = ws.getLastRowNum();
		Reporter.log("no of rows::"+rc,true);
		for (int i = 0; i <= rc; i++)
		{
			driver.get("https://www.calculator.net/percent-calculator.html");
			Thread.sleep(4000);
			if(wb.getSheet("Interest").getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				//read integer type cell data
				int celldata1 =(int)wb.getSheet("Interest").getRow(i).getCell(0).getNumericCellValue();
				//convert celldata1 into string type
				String percentage =String.valueOf(celldata1);
				if(wb.getSheet("Interest").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					int celldata2 =(int) wb.getSheet("Interest").getRow(i).getCell(1).getNumericCellValue();
					String amount = String.valueOf(celldata2);
					driver.findElement(By.name("cpar1")).sendKeys(percentage);
					driver.findElement(By.name("cpar2")).sendKeys(amount);
					driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
					Thread.sleep(4000);
					//capture results
					String Results =driver.findElement(By.xpath("//p[@class='verybigtext']")).getText();
					ws.getRow(i).createCell(2).setCellValue(Results);
					Reporter.log(percentage+"     "+amount+"       "+Results,true);
				}
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream(output);
		wb.write(fo);
		fo.close();
		wb.close();

	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

		
		
	
	
		
	
	
	


