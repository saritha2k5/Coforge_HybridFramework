package pac1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TC009_TestNG4_Properties {
	WebDriver driver;
	String projectpath;
	
	
  @Test(dataProvider = "dp")
  public void loginTest(String username, String password) {
	  Login_PageFactory obj=PageFactory.initElements(driver, Login_PageFactory.class);
	  
	  ExtentReports extent=new ExtentReports();
	  
	  ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"\\report.html");
	  extent.attachReporter(spark);
	  
	  ExtentTest test=extent.createTest("Verify the login");
	  
	  
	  
	/*  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); */
	  obj.enterusername(username);
	  obj.enterpassword(password);
	  obj.clicklogin();
	  test.pass("loginsuccess");
	  extent.flush();
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  Properties prob=new Properties();
	  
	  FileInputStream fis=new FileInputStream(projectpath+"\\data.properties");
	  prob.load(fis);
	  String url=prob.getProperty("url");
	  WebDriverManager.edgedriver().setup();
		
		 driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws EncryptedDocumentException, IOException {
	  projectpath=System.getProperty("user.dir");
	  FileInputStream file=new FileInputStream(projectpath+"\\d1.xlsx");
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
