package Project_Mav;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class frames {
 WebDriver wd;
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  wd=new ChromeDriver();
	  wd.manage().window().maximize();
	  wd.get("https://demoqa.com/frames");
  }

  @Test
  public void Frames() throws InterruptedException {
	  JavascriptExecutor js= (JavascriptExecutor)wd;
	  List<WebElement> frame= wd.findElements(By.tagName("iframe"));
	System.out.println(frame);              //frames  in web pages 
	System.out.println(frame.size());       //no of the frames in web page
	
	for (int i=0;i<8;i++)
	{
		String str = frame.get(i).getAttribute("id");
		System.out.println(str);
		
	}
	wd.switchTo().frame("frame2");
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	Thread.sleep(5000);
}

@AfterTest
  public void afterTest() {
	wd.close();
  }

}
