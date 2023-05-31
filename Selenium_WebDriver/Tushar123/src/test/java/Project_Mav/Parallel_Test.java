package Project_Mav;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
public class Parallel_Test {
        WebDriver wd;
        @Parameters("mybrowser")
        
  @BeforeTest
  public void beforeTest(String mybrowser) 
  {
	  if(mybrowser.equalsIgnoreCase("chrome")) 
	  {
		  WebDriverManager.chromedriver().setup();
		  wd=new ChromeDriver();
	  }
	  
	  else if(mybrowser.equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  wd=new FirefoxDriver();
	  }	 
	  
  }
  
  @Test(priority=0)
  public void test1() throws InterruptedException 
  {
	  Thread.sleep(2000);
	  wd.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(2000);
	  wd.findElement(By.name("username")).sendKeys("admin");
	  wd.findElement(By.name("password")).sendKeys("admin123");
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-dropdown-menu\"]/li[4]/a")).click();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
