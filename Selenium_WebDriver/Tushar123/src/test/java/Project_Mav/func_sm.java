package Project_Mav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
 
public class func_sm {
	WebDriver wd;
  @BeforeTest
  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		  wd=new ChromeDriver();
		  wd.manage().window().maximize();
		  wd.navigate().to("https://rahulshettyacademy.com/practice-project"); //navigate to amazon web site
		  
  }
  @Test
  public void func1() throws InterruptedException {
	 WebElement dr=wd.findElement(By.linkText("More"));
	 Thread.sleep(6000);
	 Actions act=new Actions(wd);
	 act.moveToElement(dr).build().perform();  //move to element is for hovering the mouse 
	 Thread.sleep(6000);
  }
  @Test
  public void func2() throws AWTException, InterruptedException {
	  Robot rc=new Robot ();
	  rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN); //scroll Down
	  Thread.sleep(4000);
	  rc.keyPress(MenuKeyEvent.VK_PAGE_UP);  //Scroll up
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class='nav-outer clearfix']/nav/div[2]/ul/li[1]")).click();//manual xpath creation.
  }

  @AfterTest
  public void afterTest() {
  }

}
