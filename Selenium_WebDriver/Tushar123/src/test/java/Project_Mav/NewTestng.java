package Project_Mav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTestng {
	WebDriver wd;
	
	@BeforeTest
	public void beforeTest1() {
		  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		  wd=new ChromeDriver();
		  wd.navigate().to("https://www.amazon.in/"); //navigate to amazon website
		  wd.manage().window().maximize();
	}
  @Test(priority=0)
  public void test1() {
	  wd.findElement(By.xpath("//*[@class=\'nav-a nav-a-2   nav-progressive-attribute\']")).click();   //click on hello sign in.
	  wd.findElement(By.xpath("//*[@id=\'ap_email\']")).sendKeys("9762941757"); // send data in email/mob no. box
	  wd.findElement(By.xpath("//*[@id=\'continue\']")).click();
	  wd.findElement(By.id("ap_password")).sendKeys("Tt@987654321");
	  wd.findElement(By.id("signInSubmit")).click();
  }
 
 @Test (priority=1)
 public void search() throws InterruptedException{ 
	 wd.findElement(By.id("twotabsearchtextbox")).sendKeys("Google Pixel 7 Pro (Obsidian, 128 GB) (12 GB RAM)");
	 wd.findElement(By.id("nav-search-submit-button")).click(); wd.findElement(By.
	 xpath("(//*[@class=\'a-size-medium a-color-base a-text-normal\'])[2]")).click(); 
	 Thread.sleep(1000);
	 }
 @Test(priority=2)
 public void switch_tab() {
 }

  @AfterTest
  public void afterTest() {
  	  wd.close();
  }
  


}


