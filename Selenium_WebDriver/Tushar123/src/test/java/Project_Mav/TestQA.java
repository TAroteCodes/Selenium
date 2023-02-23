package Project_Mav;

import org.testng.annotations.Test;
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

public class TestQA {
	WebDriver wb;
	JavascriptExecutor js;
	Robot rc;
	Actions act;
  @BeforeTest
  public void beforeTest() throws AWTException, InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
	  wb=new ChromeDriver();
	  rc=new Robot();
	  act=new Actions(wb);
	  wb.manage().window().maximize();
	  js= (JavascriptExecutor)wb;
	  wb.navigate().to("https://demoqa.com/"); //navigate to web site.
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,400)");
	  Thread.sleep(2000);
  }
  
  @Test(priority = 0)
  public void text() throws AWTException, InterruptedException {
	  wb.findElement(By.xpath("//*[@class='category-cards']/div[1]")).click();  //click on element
	  Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click(); //click on text box
		Thread.sleep(2000);
		wb.findElement(By.id("userName")).sendKeys("tushar");
		Thread.sleep(2000);
		wb.findElement(By.id("userEmail")).sendKeys("Sample@gmail.com");
		Thread.sleep(2000);
		wb.findElement(By.id("currentAddress")).sendKeys("Pune");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		wb.findElement(By.id("permanentAddress")).sendKeys("Maharashtra");
		Thread.sleep(2000);
		js.executeScript("document.getElementsByClassName('btn btn-primary')[0].click()");
		Thread.sleep(6000);
  }
  
  @Test(priority = 1)
  public void Check_Box() throws AWTException, InterruptedException 
  {
	    js.executeScript("window.scrollBy(0,700)");
	    Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click(); //click on check box
		Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@class=\"rct-checkbox\"]")).click();
		Thread.sleep(3000);
  }
  @Test(priority = 2)
  public void Radio_Button() throws InterruptedException {
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[3]")).click(); //click on radio button
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"custom-control-label\"]")).click();
		Thread.sleep(4000);
  }
  @Test(priority = 3)
  public void Web_Table() throws InterruptedException, AWTException {
	  js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[4]")).click();
	  Thread.sleep(2000);
		wb.findElement(By.xpath("//*[@class=\"action-buttons\"]/span")).click();
		Thread.sleep(1500);
		wb.findElement(By.id("firstName")).clear();
		wb.findElement(By.id("firstName")).sendKeys("Tushar");
		Thread.sleep(1500);
		wb.findElement(By.id("lastName")).clear();
		wb.findElement(By.id("lastName")).sendKeys("Arote");
		Thread.sleep(1500);
		wb.findElement(By.id("userEmail")).clear();
		wb.findElement(By.id("userEmail")).sendKeys("Sample@gmail.com");
		Thread.sleep(1500);
		wb.findElement(By.id("age")).clear();
		wb.findElement(By.id("age")).sendKeys("25");
		Thread.sleep(1500);
		wb.findElement(By.id("salary")).clear();
		wb.findElement(By.id("salary")).sendKeys("0");
		Thread.sleep(1500);
		wb.findElement(By.id("department")).clear();
		wb.findElement(By.id("department")).sendKeys("SDET");
		Thread.sleep(1500);
		wb.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
  }
  @Test(priority = 4)
  public void Buttons() throws InterruptedException, AWTException {
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[5]")).click(); //buttons
	  Thread.sleep(2000);
	  WebElement ww=wb.findElement(By.id("doubleClickBtn"));
	  act.doubleClick(ww).build().perform();
	  Thread.sleep(1500);
	  WebElement ww1=wb.findElement(By.id("rightClickBtn"));
      act.contextClick(ww1).build().perform();
      Thread.sleep(1500);
      js.executeScript("window.scrollBy(0,300)");
      Thread.sleep(1500);
      wb.findElement(By.xpath("//*[@class=\"col-12 mt-4 col-md-6\"]/div[2]/div[3]/button")).click();
      Thread.sleep(4000);
  }
  @Test(priority = 5)
  public void Links() throws AWTException, InterruptedException {
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[6]")).click(); //Links
	  Thread.sleep(1500);
      wb.findElement(By.id("created")).click();
      Thread.sleep(1500);
      js.executeScript("window.scrollBy(0,200)");
      Thread.sleep(3000);
      String parent=wb.getWindowHandle();
      wb.findElement(By.id("simpleLink")).click();
      Thread.sleep(5000);
      rc.keyPress(MenuKeyEvent.VK_CONTROL);
	  rc.keyPress(MenuKeyEvent.VK_TAB);
	  rc.keyRelease(MenuKeyEvent.VK_CONTROL);
	  rc.keyRelease(MenuKeyEvent.VK_TAB);
	  Thread.sleep(2000);
	  Set<String> allWindow = wb.getWindowHandles();  //for getting id's of all windows
	  String lastWindow="";
		
		
		for(String handle:allWindow) 
		{          
			wb.switchTo().window(handle);
			lastWindow=handle;     //getting id of last window
			wb.switchTo().window(lastWindow);             //go to new window
			Thread.sleep(1500);
		}
		wb.close();                                    //close the new window
		
		wb.switchTo().window(parent);                 //switch back to parent window
		Thread.sleep(3000);
  }
  
  @Test(priority = 6)
  public void broken_link() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[7]")).click();
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(1500);
	  wb.findElement(By.linkText("Click Here for Broken Link")).click();
	  Thread.sleep(3000);
	  wb.navigate().back();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 7)
  public void download_upload() throws InterruptedException 
  {
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(1500);
	wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[8]")).click();
	Thread.sleep(1500);
	js.executeScript("document.getElementById(\"downloadButton\").click()");
	Thread.sleep(2000);
	wb.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\lenovo\\Desktop\\writing material.jpg");
	Thread.sleep(3500);
  }
  
  @Test(priority =8)
  public void dynamic_properties() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[9]")).click();
	  Thread.sleep(7000);
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(1000);
  }
  
  @Test(priority=9)
  public void forms() throws InterruptedException 
  {
	  wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[2]")).click();
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click();
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('firstName').value='Tushar'");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('lastName').value='Arote'");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('userEmail').value='Sample@gmail.com'");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('gender-radio-1').click()");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('userNumber').value='8888812345'");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('dateOfBirthInput').click()");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementsByClassName('react-datepicker__month-select')[0].click()");
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]/option[1]")).click();
	  Thread.sleep(1000);
	  js.executeScript("document.getElementsByClassName('react-datepicker__year-select')[0].click()");
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@class=\"react-datepicker__year-select\"]/option[98]")).click();
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@class=\"react-datepicker__day react-datepicker__day--021\"]")).click();
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('hobbies-checkbox-3').click()");
	  Thread.sleep(1000);
	  wb.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\lenovo\\Desktop\\writing material.jpg");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('currentAddress').value='Pune,Maharashtra,India'");
	  Thread.sleep(1000);
	  js.executeScript("document.getElementById('submit').click()");
	  Thread.sleep(4000);
	  js.executeScript("document.getElementById('closeLargeModal').click()"); 
	  Thread.sleep(1500);
  }
  
  @Test(priority=10)
  public void brawser_windows_tab() throws InterruptedException 
  {
     wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[3]")).click();
     Thread.sleep(1000);
     wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click();
     Thread.sleep(1000);
     String parent=wb.getWindowHandle();
     Thread.sleep(1000);
     wb.findElement(By.id("tabButton")).click();
	 Thread.sleep(3000);
	 rc.keyPress(MenuKeyEvent.VK_CONTROL);
	 rc.keyPress(MenuKeyEvent.VK_TAB);
	 rc.keyRelease(MenuKeyEvent.VK_CONTROL);
	 rc.keyRelease(MenuKeyEvent.VK_TAB);
	 Thread.sleep(2000);
	 Set<String> allWindow = wb.getWindowHandles();  //for getting id's of all windows
	  String lastWindow="";
		
		
		for(String handle:allWindow) 
		{          
			wb.switchTo().window(handle);
			lastWindow=handle;     //getting id of last window
			wb.switchTo().window(lastWindow);             //go to new window
			Thread.sleep(1500);
		}
		wb.close();                                    //close the new window
		
		wb.switchTo().window(parent);                 //switch back to parent window
		Thread.sleep(3000);
	 
  }
  
  @Test(priority=11)
  public void new_window() throws InterruptedException 
  {
	  String parent=wb.getWindowHandle();              //For getting id of parent window
	  wb.findElement(By.id("windowButton")).click();
	  Thread.sleep(6000);
	  
	  Set<String> allWindow = wb.getWindowHandles();  //for getting id's of all windows
	  String lastWindow="";
		
		
		for(String handle:allWindow) 
		{          
			wb.switchTo().window(handle);
			lastWindow=handle;     //getting id of last window
			wb.switchTo().window(lastWindow);             //go to new window
			Thread.sleep(1500);
		}
		wb.close();                                    //close the new window
		wb.switchTo().window(parent);                 //switch back to parent window
		Thread.sleep(3000);
  }
  
  @Test(priority=12)
  public void new_message_window() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,100)");
	  Thread.sleep(1000);
	  wb.findElement(By.id("messageWindowButton")).click();
	  Thread.sleep(4000);
	  String parent=wb.getWindowHandle();              //For getting id of parent window
	  Set<String> allWindow = wb.getWindowHandles();  //for getting id's of all windows
	  String lastWindow="";
			
	  for(String handle:allWindow) 
	{          
	  wb.switchTo().window(handle);
	  lastWindow=handle;                            //getting id of last window
	}
			
	  wb.switchTo().window(lastWindow);             //go to new window
	  Thread.sleep(1500);
	  wb.close();                                   //close the new window
	  wb.switchTo().window(parent);                 //switch back to parent window
	  Thread.sleep(2000);
  }
  
  @Test(priority=13)
  public void Alert() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click();
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,100)");
	  Thread.sleep(500);
	  js.executeScript("document.getElementById('alertButton').click()");
	  Thread.sleep(3000);
	  Alert alt=wb.switchTo().alert();            //switch to alert
	  alt.accept();                               //accept it 
	  Thread.sleep(1500);
	  
	  js.executeScript("document.getElementById('timerAlertButton').click()");
	  Thread.sleep(8000);
	  wb.switchTo().alert();            
	  alt.accept();
	  Thread.sleep(2000);
	  
	  js.executeScript("document.getElementById('confirmButton').click()");
	  Thread.sleep(3000);
	  wb.switchTo().alert();            
	  alt.dismiss();
	  Thread.sleep(2000);
	  
	  js.executeScript("document.getElementById('promtButton').click()");
	  Thread.sleep(1500);
	  wb.switchTo().alert(); 
	  alt.sendKeys("Tushar");
	  Thread.sleep(1500);
	  alt.accept();
	  Thread.sleep(4000);
  }
  
  @Test(priority=14)
  public void frames() throws InterruptedException 
  {
	  String parent=wb.getWindowHandle();
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[3]")).click();
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2000);
	  wb.switchTo().frame("frame2");
	  js.executeScript("window.scrollBy(document.body.scrollWidth,document.body.scrollHeight)");
	  wb.switchTo().window(parent); 
	  Thread.sleep(5000); 
	  
	  
  }
  
  @Test(priority=15)
  public void Nestedframes() throws InterruptedException 
  {
	  wb.findElement(By.xpath("//span[contains(text(),'Nested Frames')]")).click();
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(2000);
  }
  
  @Test(priority=16)
  public void Model_Dialogs() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//span[contains(text(),'Modal Dialogs')]")).click();
	  Thread.sleep(2000);
	  js.executeScript("document.getElementById('showSmallModal').click()");
	  Thread.sleep(3000);
	  wb.findElement(By.id("closeSmallModal")).click();
	  Thread.sleep(2000);
	  wb.findElement(By.id("showLargeModal")).click();
	  Thread.sleep(4000);
	  wb.findElement(By.id("closeLargeModal")).click();
	  Thread.sleep(3000); 
  }
  
  @Test(priority=17)
  public void Accordian() throws InterruptedException 
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[4]/span/div")).click();
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click();
	  Thread.sleep(4000);
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(2000);
	  js.executeScript("document.getElementById('section2Heading').click()");
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,100)");
	  wb.findElement(By.id("section3Heading")).click();
	  Thread.sleep(4000);
  }
  
  @Test(priority=18)
  public void Auto_Complete() throws InterruptedException 
  {
	 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click();
	
	 wb.findElement(By.xpath("//*[@class=\"auto-complete-container\"]/div[1]/div/div/div")).click();
	 
	 rc.keyPress(MenuKeyEvent.VK_V);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_ENTER);
	 Thread.sleep(2000);
	 rc.keyPress(MenuKeyEvent.VK_I);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_N);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_ENTER);
	 Thread.sleep(2000);
	 rc.keyPress(MenuKeyEvent.VK_B);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_ENTER);
	 Thread.sleep(2000);
	 rc.keyPress(MenuKeyEvent.VK_G);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_ENTER);
	 Thread.sleep(3000);
	 wb.findElement(By.xpath("//*[@class=\"auto-complete-container\"]/div[2]/div/div/div")).click();
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_Y);
	 Thread.sleep(1000);
	 rc.keyPress(MenuKeyEvent.VK_ENTER);
	 Thread.sleep(3000);
	 js.executeScript("window.scrollBy(0,300)");
	 Thread.sleep(1000);  
  }

  @Test(priority=19)
  public void Date_picker() throws InterruptedException 
  {
		 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[3]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.id("datePickerMonthYearInput")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]/option[2]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__day react-datepicker__day--028\"]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.id("dateAndTimePickerInput")).click();
		 Thread.sleep(1000);
		 for (int i=0;i<2;i++) 
		 {
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__navigation react-datepicker__navigation--next react-datepicker__navigation--next--with-time\"]")).click();
		 Thread.sleep(1000);
		 }
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__day react-datepicker__day--028\"]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"react-datepicker__time-list\"]/li[1]")).click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,400)");
		 Thread.sleep(1000);  
  }
  
  @Test(priority=20)
  public void Slider() throws InterruptedException 
  {
	     js.executeScript("window.scrollBy(0,400)");
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[4]")).click();
		 Thread.sleep(1000);
		 WebElement we = wb.findElement(By.xpath("//*[@class=\"range-slider range-slider--primary\"]"));
		 act.dragAndDropBy(we,200,0).build().perform();
		 Thread.sleep(3000);  
  }
  
  @Test (priority=21)
  public void Progress_Bar() throws InterruptedException 
  {
	     js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[5]")).click();
		 Thread.sleep(1500);
		 wb.findElement(By.id("startStopButton")).click();
		 Thread.sleep(5000);
		 wb.findElement(By.id("startStopButton")).click();
		 Thread.sleep(2000);
		 wb.findElement(By.id("startStopButton")).click();
		 Thread.sleep(7000);
		 wb.findElement(By.id("resetButton")).click();
		 Thread.sleep(2000);
  }
  
  @Test(priority=22)
  public void Tabs() throws InterruptedException 
  {
	     js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[6]")).click();
		 Thread.sleep(1000);
		 js.executeScript("window.scrollBy(0,200)");
		 Thread.sleep(3000);
		 wb.findElement(By.id("demo-tab-origin")).click();
		 Thread.sleep(3000);
		 wb.findElement(By.id("demo-tab-use")).click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(1000);
  }
  
  @Test(priority=23)
  public void Tool_Tips() throws InterruptedException 
  {
	     wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[7]")).click();
		 Thread.sleep(1000);
		 js.executeScript("window.scrollBy(0,300)");
		 Thread.sleep(1000);
		 WebElement we= wb.findElement(By.id("toolTipButton"));
		 act.moveToElement(we).build().perform();
		 Thread.sleep(2500);
		 WebElement We= wb.findElement(By.id("toolTipTextField"));
		 act.moveToElement(We).build().perform();
		 Thread.sleep(2500);
		 WebElement WE= wb.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[1]"));
		 act.moveToElement(WE).build().perform();
		 Thread.sleep(2500);
		 WebElement W_E= wb.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[2]"));
		 act.moveToElement(W_E).build().perform();
		 Thread.sleep(2500); 
		 js.executeScript("window.scrollBy(0,400)");
		 Thread.sleep(1500);
	  
  }
  
  @Test(priority=24)
  public void Menu() throws InterruptedException
  {
	     wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[8]")).click();
		 Thread.sleep(3000);
		 WebElement we= wb.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
		 act.moveToElement(we).build().perform();
		 Thread.sleep(1500);
		 
		 for (int i=0;i<3;i++)
		 {
			 rc.keyPress(MenuKeyEvent.VK_DOWN);
			 Thread.sleep(1000);
		 }
		 WebElement WE= wb.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 2')]"));
		 act.moveToElement(WE).build().perform();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(2500);
  }
  
  @Test(priority=25)
  public void Select_Menu() throws InterruptedException 
  {
		 wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[9]")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@class=\"css-19bqh2r\"][1]")).click();
		 Thread.sleep(1000);
		 for(int i=0;i<3;i++) 
		 {
			rc.keyPress(MenuKeyEvent.VK_DOWN);
			Thread.sleep(1000);
		 }
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 wb.findElement(By.id("selectOne")).click();
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 wb.findElement(By.id("oldSelectMenu")).click();
		 Thread.sleep(1000);
		 wb.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]/option[6]")).click();
		 Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0,400)");
		 wb.findElement(By.xpath("//*[@class=\"row\"][2]/div/div")).click();
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		 Thread.sleep(2000);
		 wb.findElement(By.xpath("//*[@id=\"cars\"]/option[4]")).click();
  }
  
  @Test(priority=26)
  public void Sortable() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2500);
	  wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[5]/span/div")).click();   //click on Interactions
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click(); //click on Sort able
	  Thread.sleep(1500);
	  js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(2000);
	  
	  WebElement s1= wb.findElement(By.xpath("//*[@class=\"vertical-list-container mt-4\"]/div[1]"));  //storing web element for one 
	  Thread.sleep(1000);
	  act.dragAndDropBy(s1, 0, 320).perform();         //dragging one down by 360 pixel
	  
	  Thread.sleep(2000);
	  WebElement s2= wb.findElement(By.xpath("//*[@class=\"vertical-list-container mt-4\"]/div[1]"));  //storing web element for two
	  Thread.sleep(1000);
	  act.dragAndDropBy(s2, 0, 200).perform();        //dragging two down by 200 pixels
	   
	  Thread.sleep(2000);
	  WebElement s3= wb.findElement(By.xpath("//*[@class=\"vertical-list-container mt-4\"]/div[4]"));  //storing web element for six
	  Thread.sleep(1000);
	  act.dragAndDropBy(s3, 0, -200).perform();        //dragging two up by 200 pixels
	  
	  Thread.sleep(1500);
	  wb.findElement(By.id("demo-tab-grid")).click();                                          //click on "grid"
	  Thread.sleep(1500);
	  
	 WebElement gs1= wb.findElement(By.xpath("//*[@class=\"create-grid\"]/div[1]"));      //storing web Element for one
	 Thread.sleep(1000);
	 act.dragAndDropBy(gs1, 200, 200).perform();        //dragging one on x and y axis with 200 pixels 
	 Thread.sleep(1500);
	 
	 WebElement gs2= wb.findElement(By.xpath("//*[@class=\"create-grid\"]/div[3]"));      //storing web Element for four
	 Thread.sleep(1000);
	 act.dragAndDropBy(gs2, -200, 200).perform();        //dragging four down on x axis by -200 and on y axis by 200 pixels 
	 Thread.sleep(1500);
	 
	 WebElement gs3= wb.findElement(By.xpath("//*[@class=\"create-grid\"]/div[8]"));      //storing web Element for nine
	 Thread.sleep(1000);
	 act.dragAndDropBy(gs3, 0, -200).perform();        //dragging nine up on only y axis by 200 pixels 
	 Thread.sleep(1500);
  }
  
  @Test(priority=27)
  public void Selectable() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click();  //click on Select able
	  Thread.sleep(1500);
	  js.executeScript("window.scrollBy(0,200)");
	  Thread.sleep(1500);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[1]")).click();  //select first sentence from list
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[4]")).click();  //select fourth sentence from list
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[2]")).click();  //select Second sentence from list
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[3]")).click();  //select Third sentence from list
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[4]")).click();  //deselect fourth sentence from list
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[2]")).click();  //deselect second sentence from list
	  Thread.sleep(2500);
	  wb.findElement(By.id("demo-tab-grid")).click();                               //click on "grid"
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"gridContainer\"]/div[1]/li[1]")).click();  //select "one"
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"gridContainer\"]/div[3]/li[3]")).click();  //select "nine"
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"gridContainer\"]/div[3]/li[1]")).click();  //select "seven"
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"gridContainer\"]/div[1]/li[3]")).click();  //select "Three"
	  Thread.sleep(1000);
	  wb.findElement(By.xpath("//*[@id=\"gridContainer\"]/div[2]/li[2]")).click();  //select "five"
	  Thread.sleep(1000);
  }
  
  @Test(priority=28)
  public void resizable() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2500);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[3]")).click();  //click on resize able
	  Thread.sleep(1500);
	  js.executeScript("window.scrollBy(0,300)");
	  Thread.sleep(2000);
	  WebElement resize = wb.findElement(By.xpath("//*[@class='react-resizable-handle react-resizable-handle-se'][1]")); //storing web element 
	   act.dragAndDropBy(resize,100, 100).perform();                                           //resizing the first box
	   Thread.sleep(1000);
	   js.executeScript("window.scrollBy(0,150)");
	   Thread.sleep(1000);
	   WebElement resize2 = wb.findElement(By.xpath("//*[@id=\"resizable\"]/span"));
	   act.dragAndDropBy(resize2,10,100).perform();                                            //resizing the second box
  }
  
  @Test(priority=29)
  public void droppable() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[4]")).click();  //click on drop able 
	  Thread.sleep(1500);
	  
	  WebElement E1= wb.findElement(By.id("draggable"));      // web element for drag me
	  Thread.sleep(1000);
	  WebElement E2= wb.findElement(By.id("droppable"));      // web element for drag here
	  Thread.sleep(1000);
	  act.dragAndDrop(E1, E2).build().perform();              //dragging 'drag me' to 'drag here' 
	  Thread.sleep(2000);
	 
	  wb.findElement(By.id("droppableExample-tab-accept")).click();   //click on accept
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,100)");
	  Thread.sleep(3000);
	  WebElement AE1= wb.findElement(By.id("notAcceptable"));  //web element For not acceptable
	  Thread.sleep(1000);
	  WebElement AE2= wb.findElement(By.xpath("//*[@class=\"accept-drop-container\"]/div[2]"));      // web element for drop here
	  Thread.sleep(2000);
	  act.dragAndDrop(AE1, AE2).perform();             //dragging and dropping not acceptable to drop here
	  
	  Thread.sleep(2000);
	  WebElement AE3= wb.findElement(By.id("acceptable"));  //web element For acceptable
	  Thread.sleep(1000);
	  act.dragAndDrop(AE3, AE2).perform();             //dragging and dropping acceptable to drop here
	  Thread.sleep(2000);
	  
	  wb.findElement(By.id("droppableExample-tab-preventPropogation")).click();
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,250)");
	  Thread.sleep(2000);
	  
	  WebElement pp1= wb.findElement(By.id("dragBox"));
	  Thread.sleep(1000);
	  WebElement pp2 = wb.findElement(By.id("notGreedyDropBox"));
	  Thread.sleep(3000);
	  
	  act.dragAndDrop(pp1, pp2).perform();      //drag me -->  Outer droppable
	  Thread.sleep(2000);
	  
	  WebElement pp3 = wb.findElement(By.id("notGreedyInnerDropBox"));
	  Thread.sleep(1000);
	  
	  act.dragAndDrop(pp1, pp3).perform();      //drag me -->  Inner droppable (not greedy)
	  Thread.sleep(2000);
	  
	  WebElement pp5 = wb.findElement(By.id("greedyDropBoxInner"));
	  Thread.sleep(2000);
	  
	  act.dragAndDrop(pp1, pp5).perform();      //drag me -->  Inner droppable (greedy)
	  Thread.sleep(3000);
	  
	  WebElement pp4 = wb.findElement(By.id("greedyDropBox"));
	  Thread.sleep(2000);
	  
	  act.dragAndDrop(pp1, pp4).perform();      //drag me -->  Outer droppable
	  Thread.sleep(2000);
	 
	  wb.findElement(By.id("droppableExample-tab-revertable")).click();
	  Thread.sleep(2000);
	  
	  WebElement RB1= wb.findElement(By.id("revertable"));
	  Thread.sleep(1000);
	  WebElement RB2= wb.findElement(By.id("notRevertable"));
	  Thread.sleep(1000);
	  WebElement RB3= wb.findElement(By.xpath("//*[@class=\"revertable-drop-container\"]/div[2]"));
	  Thread.sleep(2000);
	  act.dragAndDrop(RB1, RB3).build().perform();  //revert -->drop here
	  Thread.sleep(2000);
	  act.dragAndDrop(RB2, RB3).build().perform();  //non revert --> drop here
	  Thread.sleep(2000);
  }
  
  @Test(priority=30)
  
  public void draggable() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(2000);
	  wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[5]")).click();  //click on draggable 
	  Thread.sleep(1500);
	  
	  js.executeScript("window.scrollBy(0,250)");
	  Thread.sleep(1500);
	  
	  WebElement dg= wb.findElement(By.id("dragBox"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(dg,200,200).perform();
	  Thread.sleep(1500);
	  
	  wb.findElement(By.id("draggableExample-tab-axisRestriction")).click();  //click on axis restricted
	  Thread.sleep(1500);
	  
	  WebElement x= wb.findElement(By.id("restrictedX"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(x, 150, 0).perform();    //dragging x by 150 pixel
	  Thread.sleep(1500);
	  
	  WebElement y= wb.findElement(By.id("restrictedY"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(y, 0, 100).perform();     //dragging y down by 100 pixel
	  Thread.sleep(1500);
	  
	  wb.findElement(By.id("draggableExample-tab-containerRestriction")).click();  // click on 'container restricted'
	  Thread.sleep(1500);
	  
	  WebElement r1= wb.findElement(By.xpath("//*[@class=\"draggable ui-widget-content ui-draggable ui-draggable-handle\"]"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(r1, 100, 100).perform();
	  Thread.sleep(1500);
	  
	  WebElement r2= wb.findElement(By.xpath("//*[@class=\"ui-widget-header ui-draggable ui-draggable-handle\"]"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(r2, 13, 80).perform();
	  Thread.sleep(1500);
	  
	  wb.findElement(By.id("draggableExample-tab-cursorStyle")).click();  //click on cursor style
	  Thread.sleep(1500);
	  
	  WebElement c1= wb.findElement(By.id("cursorCenter"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(c1,300, 300).perform();
	  Thread.sleep(1500);
	  
	  WebElement c2= wb.findElement(By.id("cursorTopLeft"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(c2, 150, -50).perform();
	  Thread.sleep(1500);
	  
	  WebElement c3= wb.findElement(By.id("cursorBottom"));
	  Thread.sleep(1500);
	  act.dragAndDropBy(c3, 200, -200).perform();
	  Thread.sleep(1500);
  }
  @AfterTest
  public void afterTest() 
  {
	  wb.close();
  }

}


