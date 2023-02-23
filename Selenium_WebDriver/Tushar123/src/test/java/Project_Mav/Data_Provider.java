package Project_Mav;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Data_Provider {
	WebDriver wd;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd =new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
	  }
	
  @Test(dataProvider = "dp")
  public void data_provider(String n, String s) throws InterruptedException {
	  wd.findElement(By.name("username")).sendKeys(n);
	  wd.findElement(By.name("password")).sendKeys(s);
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-dropdown-menu\"]/li[4]/a")).click();
	  Thread.sleep(2000);
	  
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "tushar", "admin123" },
      new Object[] { "admin",  "admin123" }
    };
  }
  
  @AfterTest
  public void afterTest() {
	  wd.close();
  }
}
