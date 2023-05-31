package assignment;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import orangeHRM.AddUser;
import orangeHRM.LandingPage;
import orangeHRM.LogOut;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OhrmAssignment {
	WebDriver driver;
	LandingPage loginpage;
	AddUser adduser;
	LogOut logout;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginpage = new LandingPage(driver);
		adduser = new AddUser(driver);
		logout = new LogOut(driver);

	}

	@BeforeMethod
	public void beforeMethod() { 
		loginpage.GoToURL();
		loginpage.LoginToApplication("Admin", "gCG81GzG@d");
	}

	@Test
	public void AddingNewUser() throws InterruptedException {
		Thread.sleep(13000);
		adduser.AddUserForm("j", "jacks", "admin777");
		logout.UserLogOut();
		loginpage.LoginToApplication("jacks", "admin777");
		adduser.EmployeeNameAssertion();
	}

	@AfterMethod
	public void afterMethod() {
		logout.UserLogOut();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
