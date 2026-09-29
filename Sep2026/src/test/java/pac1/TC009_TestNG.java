package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TC009_TestNG {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void loginTest(String username, String password) {
	
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser ) {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		 
	  }
	  else if(browser.equalsIgnoreCase("edge"))
	  {
	  WebDriverManager.edgedriver().setup();
		
		 driver=new EdgeDriver();
		 
	  }
	  else if(browser.equalsIgnoreCase("firefox"))
	  {
	  WebDriverManager.firefoxdriver().setup();
		
		 driver=new FirefoxDriver();
		 
	  } 
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "pooja", "welcome" },
    };
  }
}
