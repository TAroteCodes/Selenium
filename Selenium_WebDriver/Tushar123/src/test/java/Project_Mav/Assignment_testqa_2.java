package Project_Mav;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_testqa_2 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		WebDriver ww=new ChromeDriver();
		ww.manage().window().maximize();
		ww.navigate().to("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		String parent=ww.getWindowHandle();
		int i;
		for(i=0;i<3;i++) {                                 //to perform 3 click at a time
	    ww.findElement(By.id("windowButton")).click();
	    Thread.sleep(1000);
		}
		Set<String> allWindow = ww.getWindowHandles();
		String lastWindow="";
		
		for(String handle:allWindow) {          //for opening google in all windows
			ww.switchTo().window(handle);
			ww.get("https://www.google.com/");
			Thread.sleep(1000);
			lastWindow=handle;         //getting id of last window
		}
		Thread.sleep(3000);
		ww.switchTo().window(parent);
		ww.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //opening ohrm in parent window
		ww.close();                                                                    //closing parent window
		ww.switchTo().window(lastWindow);                                              //going to last window
		ww.get("https://accounts.google.com/v3/signin/identifier?dsh=S67330503%3A1670924224365073&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&emr=1&ltmpl=default&ltmplcache=2&osid=1&passive=true&rm=false&scc=1&service=mail&ss=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AeAAQh5CiEUQJ4nEKHVJGWSK9nlZgMWubQ3VhOxePYtnw3WkJK5aWnztUYvc4DYChf7rDJQbpPUBeA/");
		//opening gmail in only last window
	}

}
