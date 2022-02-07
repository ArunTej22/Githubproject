package jan19;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRows {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream("F:/testing.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Sheet3");
		XSSFRow row = ws.getRow(0);
		int rc = ws.getLastRowNum();
		int cc = row.getLastCellNum();
		System.out.println("No of rows::"+rc+"  "+"no of cells in row::"+cc);
		fi.close();
		wb.close();
		
		
		
	}

}
