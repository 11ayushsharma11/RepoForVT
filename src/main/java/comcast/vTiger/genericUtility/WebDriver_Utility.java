package comcast.vTiger.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

//@author Ayush Sharma

public class WebDriver_Utility {
	
	//Wait for the page to load before identifying any synchronized element in the DOM.
	//parameter driver
	public void pageLoadTimeout(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//After every action, it will wait for next action to perform.
	//parameter driver
	public void scriptLoadTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	//Used to wait for the element to be present in the page.
	//parameter driver
	//parameter locator
	public void waitForElementToBePresent(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//Used to wait for the element to be clickable in the page.
	//parameter driver
	//parameter element
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Used to custom wait for the element to be clickable in the page.
	//parameter driver
	//parameter element
	public void customWaitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(20, null);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Used to switch driver control to the desired window.
	//parameter driver
	//parameter partialWindowTitle
	/*public void switchToWindow(WebDriver driver, String pageTitle)
	{
		Set<String> allIds = driver.getWindowHandles();
		Iterator<String> itr = allIds.iterator();
		
		while(itr.hasNext())
		{
			String windowID = itr.next();
			String title = driver.getTitle();
			System.out.println(title + pageTitle);
			if(title.contains(pageTitle))
			{
				driver.switchTo().window(windowID);
				break;
			}
		}
		
	}*/
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> allIds = driver.getWindowHandles();
		Iterator<String> itr = allIds.iterator();
		while(itr.hasNext())
		{
			String wid = itr.next();
			driver.switchTo().window(wid);
			System.out.println(driver.getTitle() + "--" + partialWindowTitle);
			if(driver.getTitle().contains(partialWindowTitle))
			{
				System.out.println(driver.getTitle() + "++" + partialWindowTitle);
				break;
			}
		}
	}
	
	//Used to click ok on the alert pop up.
	//parameter driver
	public void switchToAlertAndAccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	//Used to cancel the alert pop up.
	//parameter driver
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	//Used to switch to the frame using index.
	//parameter driver
	//parameter index
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	//Used to switch to the frame using frame Name
	//parameter driver
	//parameter frame Name
	public void switchToFrame(WebDriver driver, String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	//Used to switch to the frame using the webelement
	//parameter driver
	//parameter element
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//Used to select element using visible text
	//parameter element
	//parameter text
	public void selectAnElement(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	//Used to select element using webelement
	//parameter element
	//parameter index
	public void selectAnElement(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	//Used to hover mouse on an element.
	//parameter driver
	//parameter element
	public void hoverMouseOnElement(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	//Used to right click on an element.
	//parameter driver
	//parameter element
	public void rightClickOnelement(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element);
	}
	
	//Used to takeScreenshotOfWebPage
	//parameter driver
	public void takeScreenshotOfWebPage(WebDriver driver)
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		Java_Utility ju = new Java_Utility();
		int r = ju.getRandomNumber();
		File dest = new File("./WebpageScreenshots/webPage"+r+".png");
		try
		{
			Files.copy(src, dest);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	//Used to takeScreenshotOfWebPage
	//parameter WebElement
	public void takeScreenshotOfWebElement(WebElement element)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		Java_Utility ju = new Java_Utility();
		int r = ju.getRandomNumber();
		File dest = new File("./WebElementScreenshots/webElement"+r+".png");
		try
		{
			Files.copy(src, dest);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
