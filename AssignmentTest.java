package com.packages.student;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AssignmentTest {
	public static WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws InterruptedException{

System.setProperty("webdriver.chrome.driver", "C:/workspace/Project/BrowserExecutables/chromedriver.exe");
		driver = new ChromeDriver();
driver.manage().window().maximize();
		
Thread.sleep(3000);


	}
	@Test()
	public void TC_Regression_126() throws IOException, InterruptedException{
	     driver.get("https://www.google.com/");
	       String keywordSearch = "news";
       driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(keywordSearch);

	     List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@role='listbox']"));
      for (int i = 0; i < allOptions.size(); i++) {
				String option = ((WebElement) allOptions.get(i)).getText();
       System.out.println("option displaying are as" +option);
	  List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + keywordSearch  + "')]"));
      Assert.assertTrue(list.size() > 0);
	}
	
}
}
