package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
		WebDriver driver;
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="txtUsername")
		WebElement Username;
		@FindBy(id = "txtPassword")
		WebElement Password;
		@FindBy(xpath = "//button[@type=\"submit\"]")
		WebElement Submit;
		@FindBy(xpath = "//li[@id=\"left_menu_item_1\"]/descendant::span[1]")
		WebElement Administration;
		
		By ByUsername= By.id("txtUsername");
		By Bypassword= By.id("txtPassword");
		By BySubmit = By.xpath("//button[@type=\"submit\"]");
		By ByAdministration = By.xpath("//li[@id=\"left_menu_item_1\"]/descendant::span[1]");
		public void LoginToApplication(String UserName ,String password)
		{
			WaitForElementVisibility(ByUsername);
			Username.sendKeys(UserName);
			WaitForElementVisibility(Bypassword);
			Password.sendKeys(password);
			WaitForElementClickable(BySubmit);
			Submit.click();
			WaitForElementClickable(ByAdministration);
			Administration.click();
		}
		
		public void GoToURL() {
			driver.get("https://pratham365-trials79.orangehrmlive.com/");
		}
}

