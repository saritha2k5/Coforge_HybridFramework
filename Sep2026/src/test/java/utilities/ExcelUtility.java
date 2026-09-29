package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getexceldata() throws IOException
	{
		String projectpath=System.getProperty("user.dir");
		  FileInputStream file=new FileInputStream(projectpath+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
	int rows=sheet.getPhysicalNumberOfRows();

	int columns=sheet.getRow(0).getPhysicalNumberOfCells();

	System.out.println("rows:"+rows);
	System.out.println("colums:"+columns);
	Object[][] data=new Object[rows-1][columns];

	for(int i=1;i<rows;i++)
	{
		
		for(int j=0;j<columns;j++)
		{
			data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			
		}
	}
		workbook.close();  
	    return data;
	}
}
