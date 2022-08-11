package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTests {
	
	@Test
	public void calendar_Popup_Test() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		String fromCity = "Delhi";
		String toCity = "Chandigarh";
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromCity);
		driver.findElement(By.xpath("//p[contains(text(),'"+fromCity+"')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toCity);
		driver.findElement(By.xpath("//p[contains(text(),'"+toCity+"')]")).click();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		Thread.sleep(3000);
		
		String dMonth = "November";
		String dYear = "2022";
		String dDate = "12";
		
		String rMonth = "January";
		String rYear = "2023";
		String rDate = "11";
		
		String dXpathC = "//div[contains(text(),'%s %s')]";
		dXpathC = String.format(dXpathC, dMonth, dYear);
		
		String rXpathC = "//div[contains(text(),'%s')]//span[text()='%s']";
		rXpathC = String.format(rXpathC, rMonth, rYear);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		while(true)
		{
			try
			{
				driver.findElement(By.xpath(dXpathC));
				String dXpath = "//div[contains(text(),'%s %s')]/ancestor::div[@class='DayPicker-Month']//div[@class='DayPicker-Day']//p[text()='%s']";
				dXpath = String.format(dXpath, dMonth, dYear, dDate);
				driver.findElement(By.xpath(dXpath)).click();
				break;
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		
		while(true)
		{
			try
			{
				driver.findElement(By.xpath(rXpathC));
				String rXpath = "//div[contains(text(),'%s')]//span[text()='%s']/ancestor::div[@class='DayPicker-Month']//div[@class='DayPicker-Day']//p[text()='%s']";
				rXpath = String.format(rXpath, rMonth, rYear, rDate);
				driver.findElement(By.xpath(rXpath)).click();
				break;
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
				
	}

}
