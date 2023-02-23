package Project_Mav;

import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testo {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		WebDriver wb=new ChromeDriver(); //creating object for chrome driver
		//Actions act=new Actions(wb);
		wb.manage().window().maximize();
		Robot rc=new Robot();
		wb.navigate().to("https://demoqa.com/alerts");
		Thread.sleep(3000);
		/*
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		
		wb.findElement(By.xpath("//*[@class='category-cards']/div[1]")).click();  //click on element
		
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[8]")).click(); 
		wb.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\lenovo\\Desktop\\writing material.jpg");
		Thread.sleep(4000);
		
		Thread.sleep(2000);
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		wb.findElement(By.xpath("//*[@class=\"left-pannel\"]/div/div[3]")).click();
		wb.findElement(By.xpath("//*[@class=\"element-list collapse show\"]/ul/li[2]")).click();
		*/
		/*
		wb.findElement(By.id("alertButton")).click();
		Alert alt=wb.switchTo().alert();
		//WebDriverWait wbw=new WebDriverWait(wb, 180); //expliicit wait for 180 sec
		//wbw.until(ExpectedConditions.alertIsPresent()); //telling webdriver accept only after pop up is appear 
		alt.accept();
		System.out.println("Alert:"+ alt.getText());
		//wb.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //implicit wait
		
		
		wb.findElement(By.id("confirmButton")).click();
		alt.dismiss(); // to cancel the thread
		*/
		
		rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		wb.findElement(By.id("promtButton")).click();
		Alert alt=wb.switchTo().alert();
		alt.sendKeys("tushar");
		alt.accept();
		
	}

}
