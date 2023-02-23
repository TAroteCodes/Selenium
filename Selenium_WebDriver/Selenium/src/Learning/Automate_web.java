package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Automate_web {

	public static void main(String[] args) throws InterruptedException { //string used to arguments to be passed in the main method
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		WebDriver wb=new ChromeDriver(); //creating object for chrome driver
		wb.navigate().to("https://www.amazon.in/"); //navigate to amazon website
		wb.manage().window().maximize();
		Thread.sleep(3000); //sleep time of 3sec.
		wb.findElement(By.xpath("//*[@class=\'nav-a nav-a-2   nav-progressive-attribute\']")).click();   //click on hello sign in.
		wb.findElement(By.xpath("//*[@id=\'ap_email\']")).sendKeys("9762941757"); // send data in email/mob no. box
		wb.findElement(By.xpath("//*[@id=\'continue\']")).click();
		wb.findElement(By.id("ap_password")).sendKeys("Tt@987654321");
		wb.findElement(By.id("signInSubmit")).click();
		wb.findElement(By.id("twotabsearchtextbox")).sendKeys("Google Pixel 7 Pro (Obsidian, 128 GB) (12 GB RAM)");
		wb.findElement(By.id("nav-search-submit-button")).click();
		wb.findElement(By.xpath("(//*[@class=\'a-size-medium a-color-base a-text-normal\'])[2]")).click();
		wb.findElement(By.name("submit.add-to-cart")).click();
		
		
	}

}
