package Project_Mav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class trial123 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); //setting the path for chrome driver
		WebDriver wb=new ChromeDriver(); //creating object for chrome driver
		wb.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
        WebElement ww=wb.findElement(By.xpath("//*[@class=\"oxd-input oxd-input--active1\"]"));
        Assert.assertEquals(true,ww.isDisplayed()); //check assertion 
        System.out.println("Assertion Passed");
        wb.close();

	}

}
