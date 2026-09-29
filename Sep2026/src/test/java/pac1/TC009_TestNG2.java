package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TC009_TestNG2 {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void loginTest(String username, String password) {
	  Login_POM obj=new Login_POM(driver);
	  
	/*  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); */
	  obj.enterusername(username);
	  obj.enterpassword(password);
	  obj.clicklogin();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.edgedriver().setup();
		
		 driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
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
