package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LogOut extends AbstractComponent {
	WebDriver driver;
	public LogOut(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement logout;
	
	By ByLogOut = By.xpath("//span[contains(text(),'Log Out')]");
	public void UserLogOut() 
	{
		WaitForElementClickable(ByLogOut);
		logout.click();
	}
}
