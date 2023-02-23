package Data_Driven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class data_driven {
	WebDriver wd;
	public String Username2,Password2,Username1,Password1;
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  wd=new ChromeDriver();
	  wd.manage().window().maximize();
	  
	  wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
  }

  @Test
  public void file() throws IOException, InterruptedException {
	  File excel =new File("C:\\Users\\lenovo\\Documents\\tEST CASES\\Data_driven_selenium.xlsx"); //file location specifying
	  FileInputStream fi =new FileInputStream(excel); //input data from sheet
	  @SuppressWarnings("resource")
	XSSFWorkbook book =new XSSFWorkbook(fi);
	  XSSFSheet sheet =book.getSheet("Sheet1");
	  
	  int row_count= sheet.getLastRowNum();
	  
	  for(int i=0;i<row_count;i++) 
	  {
		  Username1 = sheet.getRow(i).getCell(0).getStringCellValue();
		  Password1 = sheet.getRow(i).getCell(1).getStringCellValue();
		  
		  Thread.sleep(1000);
		 wd.findElement(By.name("username")).sendKeys(Username1);
		 Thread.sleep(1000);
		 wd.findElement(By.name("password")).sendKeys(Password1);
		 Thread.sleep(1000);
		 wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
		 Thread.sleep(2000);
		 
		 if (wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
		 {
			 Thread.sleep(2000);
			 wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
			 Thread.sleep(2000);
			 wd.findElement(By.xpath("//*[@class=\"oxd-dropdown-menu\"]/li[4]/a")).click();
			 Thread.sleep(2000);
		 }
		 
		 else if (wd.findElement(By.xpath("//*[@class='oxd-alert-content oxd-alert-content--error']")).isDisplayed())
		 {
			 for (int j=i+1;j<row_count;j++) 
			 {
			  Username2= sheet.getRow(j).getCell(0).getStringCellValue();
			  Password2= sheet.getRow(j).getCell(1).getStringCellValue();
			  Thread.sleep(1000);
			  wd.findElement(By.name("username")).sendKeys(Username2);
			  Thread.sleep(1000);
			  wd.findElement(By.name("password")).sendKeys(Password2);
			  Thread.sleep(1000);
			  wd.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
			  Thread.sleep(1000);
			  
			  if (wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
				 {
				  Thread.sleep(2000);
					 wd.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
					 Thread.sleep(2000);
					 wd.findElement(By.xpath("//*[@class=\"oxd-dropdown-menu\"]/li[4]/a")).click();
					 Thread.sleep(2000);
				 }
			 }
			 break;
		 }
		 
	  }
	  book.close();
  }
  
  @AfterTest
  public void afterTest() {
  }

}
