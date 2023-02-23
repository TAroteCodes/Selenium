package Learning;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class Testng {
	WebDriver driver;
@BeforeTest
public void BeforeTest() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
}

@Test(priority=0)
public void login() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys("Admin");
	 driver.findElement(By.name("password")).sendKeys("admin123"); //send password.
     driver.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")).click(); //click on login button.
     Thread.sleep(2000);
	
}

@Test(priority=1)
public void logout() throws InterruptedException {
	driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click(); //dropdown
    Thread.sleep(3000);   //waiting time
    driver.findElement(By.xpath("//*[@href=\"/web/index.php/auth/logout\"]")).click();
}
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

  
}
