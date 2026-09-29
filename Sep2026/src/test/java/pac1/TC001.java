package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.google.com/");
	
	WebElement search=driver.findElement(By.id("ti6dpd"));
	System.out.println("getattribute:"+search.getAttribute("name"));
	System.out.println("gettext:"+search.getText());
	
	
	
	if(search.isDisplayed())
	{
		System.out.println("search is available");
	search.sendKeys(Keys.SHIFT,"testing methos");
	//search.sendKeys("Testing Methods");
	}
	else
	{
		System.out.println("search is not available");
	}
	search.submit();
	
	String title;
	title=driver.getTitle();
	System.out.println("The tilte of the page is:"+title);
	
	driver.close();
	

	}

}
