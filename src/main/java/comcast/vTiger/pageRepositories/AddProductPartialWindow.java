package comcast.vTiger.pageRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPartialWindow {
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement product_Search_Field;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search_Button;
	
	private String xpathForProductName="//a[text()='"+ "%s" +"']";
	
	//WebElement Getters
	public AddProductPartialWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct_Search_Field() {
		return product_Search_Field;
	}

	public WebElement getSearch_Button() {
		return search_Button;
	}
	
	//Method to enter product name
	public void enterProductName(String productName)
	{
		getProduct_Search_Field().sendKeys(productName);
	}
	
	//Method to click on the search button
	public void clickOnSearchButton()
	{
		getSearch_Button().click();
	}
	
	//Method to click on the result of the product search
	public void clickOnProductName(WebDriver driver, String productName)
	{
		String xpath = String.format(xpathForProductName, productName);
		System.out.println(xpath);
		driver.findElement(By.xpath(xpath)).click();;
	}

}
