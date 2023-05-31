package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponent;

public class AddUser extends AbstractComponent {
	WebDriver driver;
	String Name;
	public AddUser(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class=\"btn-floating btn-large waves-effect waves-light\"]/child::i")
	WebElement adduser;
	@FindBy(id = "selectedEmployee_value")
	WebElement EmployeeName;
	@FindBy(xpath = "//*[@class=\"angucomplete-wrapper\"]/descendant::span[1]")
	WebElement EmployeeNameSugession;
	@FindBy(id = "user_name")
	WebElement UserName;
	@FindBy(xpath = "//button[@data-id=\"adminrole\"]/descendant::div[3]")
	WebElement Admin;
	@FindBy(xpath = "//*[@id=\"bs-select-3-4\"]/span")
	WebElement AdminRoll;
	@FindBy(xpath = "//*[@placeholder=\"Enter Password\"]")
	WebElement passWord;
	@FindBy(id = "confirmpassword")
	WebElement ConfirmPassword;
	@FindBy(xpath = "//*[@id=\"modal-save-button\"]")
	WebElement save;
	@FindBy(xpath = "//*[@class=\"toast-message\" or contains(text(),'Successfully Saved')]")
	WebElement SuccessMessage;
	@FindBy(xpath = "//*[@id=\"modal-save-button\"]")
	WebElement FinalSubmit;
	@FindBy(xpath = "//*[@class=\"name\"]")
	WebElement EmpName;
	
	By ByAddUser = By.xpath("//*[@class=\"btn-floating btn-large waves-effect waves-light\"]/child::i");
	By ByEmployeeName = By.id("selectedEmployee_value");
	By ByEmployeeNameSugession = By.xpath("//*[@class=\"angucomplete-wrapper\"]/descendant::span[1]");
	By ByUserName = By.id("user_name");
	By ByAdmin = By.xpath("//button[@data-id=\"adminrole\"]/descendant::div[3]");
	By ByAdminRoll = By.xpath("//*[@id=\"bs-select-3-4\"]/span");
	By ByPassword = By.xpath("//*[@placeholder=\"Enter Password\"]");
	By ByConfirmPassword = By.id("confirmpassword");
	By BySave = By.xpath("//*[@id=\"modal-save-button\"]");
	By BySuccessMessage = By.xpath("//*[@class=\"toast-message\" or contains(text(),'Successfully Saved')]");
	By ByFinalSubmit = By.xpath("//*[@id=\"modal-save-button\"]");
	By ByEmpName = By.xpath("//*[@class=\"name\"]");
	public void AddUserForm(String initial,String username,String password) 
	{
		WaitForElementClickable(ByAddUser);
		adduser.click();
		WaitForElementVisibility(ByEmployeeName);
		EmployeeName.sendKeys(initial);
		WaitForElementVisibility(ByEmployeeNameSugession);
		Name = EmployeeNameSugession.getText();
		EmployeeNameSugession.click();
		WaitForElementVisibility(ByUserName);
		UserName.sendKeys(username);
		WaitForElementClickable(ByAdmin);
		Admin.click();
		WaitForElementVisibility(ByAdminRoll);
		AdminRoll.click();
		WaitForElementVisibility(ByPassword);
		passWord.sendKeys(password);
		WaitForElementVisibility(ByConfirmPassword);
		ConfirmPassword.sendKeys(password);
		WaitForElementClickable(BySave);
		save.click();
		WaitForElementVisibility(BySuccessMessage);
		Assert.assertTrue(SuccessMessage.isDisplayed());
		WaitForElementClickable(ByFinalSubmit);
		FinalSubmit.click();
	}
	public void EmployeeNameAssertion() 
	{
		WaitForElementVisibility(ByEmpName);
		String Empname = EmpName.getText();
		Assert.assertEquals(Name, Empname);
	}
}
