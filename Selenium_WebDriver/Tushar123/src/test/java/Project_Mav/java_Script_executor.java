package Project_Mav;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class java_Script_executor {
        WebDriver wd;
 
        
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  wd=new ChromeDriver();
	 		  
  }

  
  @Test
  public void testcase1() throws InterruptedException {
	  wd.get("https://demoqa.com/text-box");
	  JavascriptExecutor js=(JavascriptExecutor)wd; //java script executor taking place of web driver (replacing)
	  Thread.sleep(2000);
	  
	  js.executeScript("document.getElementById('userName').value='tushar'");
	  js.executeScript("document.getElementById('userEmail').value='Sample@mail.com'");
	  js.executeScript("document.getElementById('currentAddress').value='Maharashtra,India'");
	  js.executeScript("document.getElementById('permanentAddress').value='Maharashtra,India'");
	  js.executeScript("document.getElementById('submit').click()");
	  js.executeScript("window.scrollBy(0,600)");  //scrolling page down(0 for x axis and 600 for y axis)
	  
	  System.out.println(js.executeScript("return document.title")); //getting title
	  System.out.println(js.executeScript("return document.domain")); //getting url
	 
	  System.out.println(js.executeScript("return document.getElementById('submit').innerText")); //getting text from perticular location
	  Thread.sleep(5000);
	  
	// System.out.println(js.executeScript("return document.documentElement.innerText")); //getting all text from page
	 //js.executeScript("history.go(0)");
	  //js.executeScript("window.history.forward(0)");  //visit the last web page in history
  }
  
  @Test
  public void testcase2() throws InterruptedException
  {
	  wd.get("https://demoqa.com/buttons");
	  Thread.sleep(3000);
	  
	  Actions act=new Actions(wd);
	  JavascriptExecutor js=(JavascriptExecutor)wd;
	  
	  js.executeScript("document.getElementsByClassName('btn btn-primary')[2].click()"); //clicking on the button
	  
	  WebElement x=wd.findElement(By.id("rightClickBtn"));      //we can use both web driver and java script executor in same method.
	  act.contextClick(x).build().perform();                   //double click and context click is very difficult to execute in JSE.
	  WebElement y=wd.findElement(By.id("doubleClickBtn"));
	  act.doubleClick(y).build().perform();
	  
	  
	 
	  
	  js.executeScript("window.scrollBy(0,500)");          //scroll down on y axis by 500 pixels
	  
	  Thread.sleep(5000);
  }
  
  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
