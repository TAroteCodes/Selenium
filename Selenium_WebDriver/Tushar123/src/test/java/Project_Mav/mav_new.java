package Project_Mav;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class mav_new {
	WebDriver wd;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
	  wd=new ChromeDriver();
	  wd.navigate().to("https://google.com/"); //navigate to amazon website
	  wd.manage().window().maximize();
  }
  @Test
  public void actions() throws InterruptedException, AWTException {
	  WebElement link =wd.findElement(By.xpath("//*[contains(text(),'Gmail')]"));
	  Thread.sleep(2000);
	  Actions act=new Actions(wd);
	  act.contextClick(link).build().perform();
	  
	  Robot rc=new Robot();
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  rc.keyPress(MenuKeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	  rc.keyPress(MenuKeyEvent.VK_CONTROL);
	  rc.keyPress(MenuKeyEvent.VK_TAB);
	  Thread.sleep(1000);
	  rc.keyPress(MenuKeyEvent.VK_CONTROL);
	  rc.keyPress(MenuKeyEvent.VK_TAB);
	  
  }
  @AfterTest
  public void afterTest() {
  }

}
