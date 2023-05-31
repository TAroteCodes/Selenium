package Learning;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Specify_WD {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
        WebDriver wd=new ChromeDriver(); 
        wd.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000); //to stop loading the web site.
        wd.findElement(By.name("username")).sendKeys("Admin"); // by name .
        //wd.findElement(By.xpath("//*[@class=\'oxd-input oxd-input--active\']")).sendKeys("Admin"); // by xpath  .
        wd.findElement(By.name("password")).sendKeys("admin123"); //send password.
        //wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        @SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")));
        wd.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")).click(); //click on login button.
        Thread.sleep(2000);   //waiting time 
        wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-chevron-left\"]")).click();
        wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click(); //drop down
        Thread.sleep(3000);   //waiting time
        wd.findElement(By.xpath("//*[@href=\"/web/index.php/auth/logout\"]")).click(); //logout
        wd.close(); //close browser
        
	}

}
      