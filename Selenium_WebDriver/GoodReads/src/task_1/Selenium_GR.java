package task_1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_GR {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
        WebDriver wd=new ChromeDriver(); 
        wd.manage().window().maximize();
        Actions act=new Actions(wd);
        wd.navigate().to("https://www.goodreads.com/");
        //navigate complete
        Thread.sleep(3000); 
        wd.findElement(By.xpath("//*[@class=\"promoHeader__promoMastheadContent\"]/div/div[3]/div/div/a")).click();
        wd.findElement(By.xpath("//*[@class=\"gr-button gr-button--dark gr-button--auth authPortalConnectButton authPortalSignInButton\"]")).click();
        wd.findElement(By.id("ap_email")).sendKeys("bacili5478@covbase.com");
        wd.findElement(By.id("ap_password")).sendKeys("Swap123");
        wd.findElement(By.id("signInSubmit")).click();
        // Login completed
        wd.findElement(By.xpath("//*[@class=\"searchBox__input searchBox__input--navbar\"]")).sendKeys("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones");
        act.sendKeys(Keys.ENTER).perform();
        
        wd.findElement(By.xpath("//*[@class=\"progressTrigger\"]")).click();
        wd.findElement(By.xpath("//*[@class=\"siteHeader__primaryNavInline\"]/ul/li[2]/a")).click();
        wd.findElement(By.xpath("//*[@class=\"col reviewListLeft\"]/div/div/div/div/div[3]/a")).click();
        Thread.sleep(3000);
        wd.findElement(By.xpath("//*[@class=\"actionLinkLite smallText deleteLink\"]")).click();
        Thread.sleep(3000);
        
        Alert alt=wd.switchTo().alert();  //navigate to pop up alert
        alt.accept();                     //press "ok" on pop up.
        
        wd.findElement(By.xpath("//*[@class=\"siteHeader__personal\"]/ul/li[5]/div/a/span/img")).click();
        wd.findElement(By.xpath("//*[@class=\"menuLink\"][13]/a")).click();
        
       
	}

}
