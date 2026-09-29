package pac1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://letcode.in/alert");
		
		driver.findElement(By.id("accept")).click();
		
		Thread.sleep(5000);
		
		Alert simplealert=driver.switchTo().alert();
		simplealert.accept();
		
		driver.findElement(By.id("confirm")).click();
		
		Alert confirmalert=driver.switchTo().alert();
		
		System.out.println("confirm alert messge:"+confirmalert.getText());
		confirmalert.accept();
		
		
	driver.findElement(By.id("prompt")).click();
		
		Alert promptalert=driver.switchTo().alert();
		
		System.out.println("prompt alert messge:"+promptalert.getText());
		promptalert.sendKeys("Hi");
		promptalert.accept();
		
		
		driver.quit();
	

	}

}
