package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {
	
	@Test
	public void handle_Web_Table()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/AyushSharma/Downloads/TY%20Lecture%2010/htmlTable.html");
		List<WebElement> rowElements = driver.findElements(By.tagName("tr"));
		WebElement element = rowElements.get(3);
		List<WebElement> columnElements = element.findElements(By.tagName("td"));
		String text = columnElements.get(1).getText();
		System.out.println(text);
	}
	
}
