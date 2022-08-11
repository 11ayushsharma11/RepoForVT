package comcast.vTiger.pageRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	private String xpathForProductInformationHeading = "//span[contains(text(),'" + "%s" +" -  Product Information')]";
	
	@FindBy(xpath="(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement delete_Button;
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getProductInformationHeading(WebDriver driver, String prodName)
	{
		String xpath =  String.format(xpathForProductInformationHeading, prodName);
		System.out.println(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
	}

	public WebElement getDelete_Button() {
		return delete_Button;
	}
	
	//Method to click on the delete button
	public void clickDeleteButton()
	{
		getDelete_Button().click();
	}

}
