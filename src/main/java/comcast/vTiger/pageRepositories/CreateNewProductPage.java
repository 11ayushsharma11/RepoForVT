package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productName_Field;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save_Button;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement getters
	public WebElement getProductName_Field() {
		return productName_Field;
	}

	public WebElement getSave_Button() {
		return save_Button;
	}
	
	//Method to enter product name
	public void enterProductName(String prodName)
	{
		getProductName_Field().sendKeys(prodName);
	}
	
	//Method to click the save button
	public void clickSaveButton()
	{
		getSave_Button().click();
	}

}
