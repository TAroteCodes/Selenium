package Project_Mav;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report {
ExtentReports extent;
ExtentTest logger;
WebDriver wd;
	
@BeforeTest
public void BT()
{
extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/tushar.html",true); //we try to save html file in the test output folder by the name of tushar
extent.loadConfig(new File(System.getProperty("user.dir")+"src/test/java/extent-config.xml")); //we try to load configurations to html fileby saving it in the src/test/java

WebDriverManager.chromedriver().setup();
wd=new ChromeDriver();
}
	
  @Test
  public void Ohrm_Login() throws InterruptedException {
	  logger=extent.startTest("Demo1");  //this indicates that logger will have infuance on the test (we are starting logger)
	  wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
	  logger.log(LogStatus.PASS,"Web Page has opened"); //in the report we will have a record of the step performed
	  
	  String title=wd.getTitle();
	  logger.log(LogStatus.PASS, title);
	  
	  Assert.assertEquals("tushar", "tushar");
	  logger.log(LogStatus.PASS, "Assert Passed");
	  
	  wd.findElement(By.name("username")).sendKeys("Admin");
	  logger.log(LogStatus.PASS, "Username is entered");
	  
	  wd.findElement(By.name("password")).sendKeys("admin123");
	  logger.log(LogStatus.PASS, "password is entered");
	  Thread.sleep(2000);
	  
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
	  logger.log(LogStatus.PASS, "login successfull");
	  Thread.sleep(2000);
  }
  
  @Test (dependsOnMethods ="Ohrm_Login" )
  public void ohrm_Logout()  throws InterruptedException {
	  
	  wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
	  logger.log(LogStatus.PASS, "clicking on the dropdown");
	  Thread.sleep(2000);
	  
	  
	  wd.findElement(By.xpath("//*[@class=\"oxd-dropdown-menu\"]/li[4]/a")).click();
	  logger.log(LogStatus.PASS, "Logged out");
	  Thread.sleep(2000);
  }
  
  @AfterTest
  public void AT() {
	  wd.close();
	  extent.endTest(logger);  //these is ends the logger 
	  
	  extent.flush(); //this will flush all the logged data in to the html report 
	  extent.close(); //this is give an end to the report
  }
  
}
