package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Navigations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println("title:"+driver.getTitle());
driver.navigate().to("https://www.yahoo.com/");
		
		System.out.println("title:"+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("title after back:"+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("title after forward:"+driver.getTitle());
		System.out.println("url after forward:"+driver.getCurrentUrl());
	//	System.out.println("url after forward:"+driver.getPageSource());
	}

}
