package rahulshetty_academy;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class rs_assignment {
  
	WebDriver wd;
	JavascriptExecutor js;
	Robot rc;
	
  @BeforeTest
  public void beforeTest() throws InterruptedException, AWTException 
  {
	  WebDriverManager.chromedriver().setup();
	  wd=new ChromeDriver();
	  wd.manage().window().maximize();
	  js= (JavascriptExecutor)wd;
	  rc= new Robot();
	  wd.get("https://rahulshettyacademy.com/AutomationPractice/");
	  Thread.sleep(3000);
  }

  @Test(priority=0)
  public void RB_Example() throws InterruptedException {
	  
	  js.executeScript("document.getElementsByClassName(\"radioButton\")[0].click()"); //click on radio button 1
	  Thread.sleep(1500);
	  js.executeScript("document.getElementsByClassName(\"radioButton\")[1].click()");
	  Thread.sleep(1500);
	  js.executeScript("document.getElementsByClassName(\"radioButton\")[2].click()");
	  Thread.sleep(3000);
  }
  
  @Test(priority=1)
  public void Suggestion() throws InterruptedException 
  {
	  wd.findElement(By.id("autocomplete")).sendKeys("ind");  //input "ind" only in text box
	  Thread.sleep(1500);
	  wd.findElement(By.xpath("//*[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front\"]/li[2]")).click();  //select "India" from the suggestion
	  Thread.sleep(3000);
  }
  
  @Test(priority=2)
  public void Dropdown() throws InterruptedException
  {
	  wd.findElement(By.xpath("//*[@class=\"cen-right-align\"]/fieldset/select")).click();  //click on drop down box
	  Thread.sleep(1500);
	  wd.findElement(By.xpath("//*[@class=\"cen-right-align\"]/fieldset/select/option[2]")).click();  //Option 1 is selected from the drop down
	  Thread.sleep(4000);
	  wd.findElement(By.xpath("//*[@class=\"cen-right-align\"]/fieldset/select/option[4]")).click(); //Option 1 ---> Option 3
	  Thread.sleep(3000);
  }
  
  @Test(priority=3)
  public void checkbox() throws InterruptedException
  {
	  js.executeScript("document.getElementById(\"checkBoxOption1\").click()");  //click on Option 1 Check Box
	  Thread.sleep(1500);
	  js.executeScript("document.getElementById(\"checkBoxOption2\").click()");
	  Thread.sleep(1500);
	  js.executeScript("document.getElementById(\"checkBoxOption3\").click()");
	  Thread.sleep(3000);
  }
  
  @Test(priority=4)
  public void Switch_window() throws InterruptedException 
  {
	  wd.findElement(By.id("openwindow")).click();     //click on "open window" button
	  Thread.sleep(6000);
	  String parent=wd.getWindowHandle();              //For getting id of parent window
	  Set<String> allWindow = wd.getWindowHandles();  //for getting id's of all windows
		String lastWindow="";
		
		for(String handle:allWindow) {          
			wd.switchTo().window(handle);
			lastWindow=handle;                        //getting id of last window
		}
		
		wd.switchTo().window(lastWindow);             //go to new window
		Thread.sleep(1500);
		wd.close();                                   //close the new window
		wd.switchTo().window(parent);                 //switch back to parent window
		Thread.sleep(3000);
  }
  
  @Test(priority=5)
  public void Switch_Tab() throws AWTException, InterruptedException 
  {
	 js.executeScript("document.getElementById(\"opentab\").click()");   //click on "open tab" button
	 Thread.sleep(6000);
	 
	 rc.keyPress(MenuKeyEvent.VK_CONTROL);                              // Control + Tab
	 rc.keyPress(MenuKeyEvent.VK_TAB);                                  //switch back to parent tab
	 rc.keyRelease(MenuKeyEvent.VK_CONTROL);
	 rc.keyRelease(MenuKeyEvent.VK_TAB);
	 Thread.sleep(3000);
	 
  }
  
  @Test(priority=6)
  public void Switch_To_Alert() throws InterruptedException 
  {
	  js.executeScript("document.getElementsByName(\"enter-name\")[0].value='Rahul Shetty'");   //entering the name 
	  Thread.sleep(1500);
	  wd.findElement(By.id("alertbtn")).click();                                               //click on alert button
	  Thread.sleep(2500);
	  Alert alt=wd.switchTo().alert();
	  alt.accept();                                                                            //click on OK (on pop up)
	  Thread.sleep(2000);
	  wd.findElement(By.id("confirmbtn")).click();                                             //click on confirm button
	  Thread.sleep(2500);
	  alt.dismiss();                                                                           //click on cancel button(on pop up)
	  Thread.sleep(3000);
  }
  
  @Test(priority=7)
  public void Element_Display() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,600)");                             //scroll down page
	  Thread.sleep(1000);
	  wd.findElement(By.id("hide-textbox")).click();                          //click on hide button
	  Thread.sleep(3000);
	  wd.findElement(By.id("show-textbox")).click();                          //click on show button
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('displayed-text').value='Bingo!'");  //insert text in text box
	  Thread.sleep(4000);
  }
  
  @Test(priority=8)
  public void table() throws InterruptedException 
  {
	  js.executeScript("document.getElementsByClassName('tableFixHead')[0].scrollBy(0,document.body.scrollHeight)"); //Scroll Down table 
	  Thread.sleep(3000);
  }
  
  @Test(priority=9)
  public void Mouse_hover() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,600)");                   //scroll down by 600 pixel
	  Thread.sleep(1500);
	  WebElement mh=wd.findElement(By.id("mousehover"));
	  Actions act=new Actions(wd);
	  act.moveToElement(mh).build().perform();
	  Thread.sleep(4000);
	  wd.findElement(By.xpath("//*[@class=\"mouse-hover-content\"]/a[2]")).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=10)
  public void iframe() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,1500)");
	  Thread.sleep(3500);
	  wd.switchTo().frame("courses-iframe");                              //switch to frame 
	  
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");  //scroll down frame
	  Thread.sleep(3000);
  }
  

  @AfterTest
  public void afterTest() {
	 wd.close();
  }

}
