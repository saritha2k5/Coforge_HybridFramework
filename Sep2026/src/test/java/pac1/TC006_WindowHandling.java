package pac1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://letcode.in/window");
		
		driver.findElement(By.id("multi")).click();
		String parentwindow=driver.getWindowHandle();		
		Set<String> allwindows=driver.getWindowHandles();
		
		for(String windows:allwindows)
		{
			System.out.println(windows);
			if(!windows.equals(parentwindow))
			{
				driver.switchTo().window(windows);
				System.out.println("url:"+driver.getCurrentUrl());
			}
		}
		
		driver.close();
		driver.quit();
		
	}

}
