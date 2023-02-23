package Project_Mav;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sm_prac2 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		WebDriver wb=new ChromeDriver(); //creating object for chrome driver
		Actions act=new Actions(wb);
		wb.manage().window().maximize();
		Robot rc=new Robot();
		wb.navigate().to("https://demoqa.com/");
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		wb.findElement(By.xpath("//*[@class='category-cards']/div[1]")).click();  //click on element
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[1]")).click(); //click on text box
		
		wb.findElement(By.id("userName")).sendKeys("tushar");
		wb.findElement(By.id("userEmail")).sendKeys("Sample@gmail.com");
		wb.findElement(By.id("currentAddress")).sendKeys("Pune");
		wb.findElement(By.id("permanentAddress")).sendKeys("Maharashtra");
		wb.findElement(By.xpath("//*[@class=\'btn btn-primary\']")).click();// click on submit button
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
		rc.keyPress(MenuKeyEvent.VK_PAGE_UP);
		
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click(); //click on check box
		wb.findElement(By.xpath("//*[@class=\"rct-checkbox\"]")).click();
		Thread.sleep(3000);
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[3]")).click(); //click on radio button
		wb.findElement(By.xpath("//*[@class=\"custom-control-label\"]")).click();
		Thread.sleep(3000);
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[4]")).click();
		wb.findElement(By.xpath("//*[@class=\"action-buttons\"]/span")).click();
		wb.findElement(By.id("firstName")).clear();
		wb.findElement(By.id("firstName")).sendKeys("Tushar");
		wb.findElement(By.id("lastName")).clear();
		wb.findElement(By.id("lastName")).sendKeys("Arote");
		wb.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[5]")).click(); //buttons
		Thread.sleep(2000);
		WebElement ww=wb.findElement(By.id("doubleClickBtn"));
	    act.doubleClick(ww).build().perform();
	    Thread.sleep(1000);
	    WebElement ww1=wb.findElement(By.id("rightClickBtn"));
        act.contextClick(ww1).build().perform();
        Thread.sleep(1000);
        WebElement ww2=wb.findElement(By.id("FrLKF"));
        ww2.click();
        Thread.sleep(3000);
        
        
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[6]")).click(); //Links
        wb.findElement(By.id("created")).click();
        rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
        Thread.sleep(10000);
        rc.keyPress(MenuKeyEvent.VK_PAGE_UP);
        wb.findElement(By.id("dynamicLink")).click();
        Thread.sleep(5000);
        rc.keyPress(MenuKeyEvent.VK_CONTROL);
  	    rc.keyPress(MenuKeyEvent.VK_TAB);
  	    rc.keyRelease(MenuKeyEvent.VK_CONTROL);
        /*
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[5]")).click();
		Thread.sleep(1000);
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[4]")).click();
		WebElement link =wb.findElement(By.id("draggable"));
		WebElement link1 =wb.findElement(By.id("droppable"));
		act.dragAndDrop(link, link1).build().perform();
		Thread.sleep(10000);
		
		wb.close();
		*/
	}

}
