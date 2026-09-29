package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PageFactory {

	//WebDriver driver;
	
	
	//By uname=By.name("username");
	@FindBy(name="username")
	WebElement uname;
	//By pword=By.name("password");
	@FindBy(name="password")
	WebElement pword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	//By loginbutton=By.xpath("//button[@type='submit']");
	


	public void enterusername(String username)
	{
		uname.sendKeys(username);
	}
	
	public void enterpassword(String password)
	{
		pword.sendKeys(password);
	}
	
	public void clicklogin()
	{
		loginbutton.click();
	}
	
}
