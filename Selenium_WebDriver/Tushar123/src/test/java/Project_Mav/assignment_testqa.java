package Project_Mav;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_testqa {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		WebDriver ww=new ChromeDriver();
		Robot rc=new Robot();
		ww.manage().window().maximize();
		ww.navigate().to("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		ww.findElement(By.id("tabButton")).click();
		Thread.sleep(3000);
		rc.keyPress(MenuKeyEvent.VK_CONTROL);
		rc.keyPress(MenuKeyEvent.VK_TAB);
		rc.keyPress(MenuKeyEvent.VK_CONTROL);
		String parentWindow= ww.getWindowHandle();  //to get id of parent window
		System.out.println(parentWindow);           //print that id
		ww.findElement(By.id("messageWindowButton")).click();
		int i;
		for(i=0;i<3;i++) {                                 //to perform 3 click at a time
	    ww.findElement(By.id("windowButton")).click();
	    Thread.sleep(1000);
		}
     Set<String> allWindow=ww.getWindowHandles(); //Id's of all windows
     System.out.println(allWindow);  //printing all id's
     System.out.println(allWindow.size()); //printing quantity of all id's
	}

}
