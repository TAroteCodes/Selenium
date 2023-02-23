package Project_Mav;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Ohrm_assignmennt {
	WebDriver wd;
	JavascriptExecutor js;
	Robot rc;
  @BeforeTest
  public void beforeTest() throws InterruptedException, AWTException {
	  WebDriverManager.chromedriver().setup();
	  wd=new ChromeDriver();
	  wd.manage().window().maximize();
	  js= (JavascriptExecutor)wd;
	  rc= new Robot();
	  wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
  }

  @Test(priority=0)
  public void Login() throws InterruptedException 
  {
	  wd.findElement(By.name("username")).sendKeys("Admin");
	  Thread.sleep(1000);
	  wd.findElement(By.name("password")).sendKeys("admin123");
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=1)
  public void Admin() throws InterruptedException 
  {
	  wd.findElement(By.xpath("//*[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"][1]")).click();
	  Thread.sleep(1000);
	  System.out.println(js.executeScript("return document.title")); //getting title
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-select-text-input\"][1]")).click();
	  Thread.sleep(1000);
	  for (int i=0;i<2;i++) 
	  {
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
	  }
	  rc.keyPress(MenuKeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=2)
  public void user_delete() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,400)");
	  Thread.sleep(1500);
	  js.executeScript("document.getElementsByClassName('oxd-icon bi-check oxd-checkbox-input-icon')[6].click()");
	  Thread.sleep(1500);
	  js.executeScript("document.getElementsByClassName('oxd-icon bi-trash')[5].click()");
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")).click();
	  Thread.sleep(3000);
  }
  @AfterTest
  public void afterTest() {
	 wd.close();
  }

}
